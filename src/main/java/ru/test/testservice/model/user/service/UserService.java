package ru.test.testservice.model.user.service;

import ru.test.testservice.model.user.service.dto.UserDto;

import java.util.List;

public interface UserService {
    void importFromFiles();
    void saveAll(List<UserDto> users);
}
