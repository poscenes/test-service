package ru.test.testservice.fileadapter.converter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.test.testservice.fileadapter.bind.UserData;
import ru.test.testservice.model.user.service.dto.UserDto;

@Component
public class DataToUserDtoConverter {

    public UserDto convert(UserData data) {
        UserDto userDto = new UserDto();

        userDto.setName(data.getName());
        userDto.setAge(data.getAge());
        userDto.setCity(data.getCity());

        return userDto;
    }
}
