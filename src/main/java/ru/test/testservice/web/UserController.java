package ru.test.testservice.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.test.testservice.model.user.service.UserService;
import ru.test.testservice.model.user.service.dto.UserDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/fill-users-table-from-file")
    public void fillUsersTableFromFile() {
        userService.importFromFiles();
    }

    @PostMapping("/fill-users-table-from-json")
    public void fillUsersTableFromJSON(@RequestBody List<UserDto> users) {
        userService.saveAll(users);
    }
}
