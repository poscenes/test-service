package ru.test.testservice.model.user.service.importation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.test.testservice.model.user.dao.UserStorageService;
import ru.test.testservice.model.user.service.converter.DtoToEntityConverter;
import ru.test.testservice.model.user.service.dto.UserDto;
import ru.test.testservice.model.user.service.importation.adapter.FileAdapter;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersCSVFilesUploader {

    private final FileAdapter fileAdapter;
    private final DtoToEntityConverter dtoToEntityConverter;
    private final UserStorageService userStorageService;

    public void performImport() {
        List<UserDto> userDtos = fileAdapter.uploadFromInDirectory();

        userDtos.stream()
                .map(dtoToEntityConverter::convert)
                .forEach(userStorageService::save);
    }
}
