package ru.test.testservice.fileadapter;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.test.testservice.fileadapter.bind.UserData;
import ru.test.testservice.fileadapter.converter.DataToUserDtoConverter;
import ru.test.testservice.fileadapter.settings.FileImportSettings;
import ru.test.testservice.model.user.service.dto.UserDto;
import ru.test.testservice.model.user.service.importation.adapter.FileAdapter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@Slf4j
public class FileAdapterImpl implements FileAdapter {

    private final FileImportSettings fileImportSettings;
    private final DataToUserDtoConverter dataToDtoConverter;

    @Override
    public List<UserDto> uploadFromInDirectory() {
        String inputDirectory = fileImportSettings.getInputDirectory();
        try (Stream<Path> paths = Files.walk(Paths.get(inputDirectory))) {
            List<Path> csvFiles = paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".csv"))
                    .toList();

            return csvFiles.stream()
                    .map(Path::toFile)
                    .map(this::parseCsvToDto)
                    .flatMap(Collection::stream)
                    .map(dataToDtoConverter::convert)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
            throw new RuntimeException("Ошибка при определении директории с файлами для импорта", e);
        }
    }

    private List<UserData> parseCsvToDto(File file){
        try (Reader reader = new BufferedReader(new FileReader(file))) {
            CsvToBean<UserData> csvToBean = new CsvToBeanBuilder<UserData>(reader)
                    .withType(UserData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .withSeparator(';')
                    .build();

            return csvToBean.parse();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new RuntimeException("Ошибка при чтении CSV файла", e);
        }
    }
}
