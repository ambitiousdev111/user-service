package com.userservice.controller;

import com.userservice.dto.UserDto;
import com.userservice.model.User;
import com.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDto userDto){
        User savedUser = userService.saveUser(userDto);
        return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
    }

}
