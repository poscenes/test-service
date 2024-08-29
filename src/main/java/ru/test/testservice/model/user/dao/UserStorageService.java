package ru.test.testservice.model.user.dao;

import ru.test.testservice.model.user.entity.User;

public interface UserStorageService {

    void save(User user);
}
