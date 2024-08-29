package ru.test.testservice.model.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.testservice.model.user.dao.UserStorageService;
import ru.test.testservice.model.user.service.converter.DtoToEntityConverter;
import ru.test.testservice.model.user.service.dto.UserDto;
import ru.test.testservice.model.user.service.importation.UsersCSVFilesUploader;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersCSVFilesUploader csvFilesUploader;
    private final DtoToEntityConverter dtoToEntityConverter;
    private final UserStorageService userStorageService;

    @Override
    public void importFromFiles() {
        csvFilesUploader.performImport();
    }

    @Override
    @Transactional
    public void saveAll(List<UserDto> users) {
        users.stream()
            .map(dtoToEntityConverter::convert)
            .forEach(userStorageService::save);
    }
}
