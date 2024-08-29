package ru.test.testservice.model.user.service.importation.adapter;

import ru.test.testservice.model.user.service.dto.UserDto;

import java.util.List;

public interface FileAdapter {
    List<UserDto> uploadFromInDirectory();
}
