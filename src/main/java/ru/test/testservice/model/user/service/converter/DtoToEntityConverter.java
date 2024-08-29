package ru.test.testservice.model.user.service.converter;

import org.springframework.stereotype.Component;
import ru.test.testservice.model.user.entity.User;
import ru.test.testservice.model.user.service.dto.UserDto;

@Component
public class DtoToEntityConverter {

    public User convert(UserDto dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setCity(dto.getCity());

        return user;
    }
}
