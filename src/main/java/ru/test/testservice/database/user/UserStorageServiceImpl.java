package ru.test.testservice.database.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.test.testservice.model.user.dao.UserStorageService;
import ru.test.testservice.model.user.entity.User;

@Component
@RequiredArgsConstructor
public class UserStorageServiceImpl implements UserStorageService {

    private final UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
