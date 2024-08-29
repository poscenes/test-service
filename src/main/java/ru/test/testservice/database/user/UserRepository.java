package ru.test.testservice.database.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.test.testservice.model.user.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
