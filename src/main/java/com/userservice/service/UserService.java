package com.userservice.service;

import com.userservice.dto.UserDto;
import com.userservice.model.User;
import com.userservice.repository.IUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(UserDto userDto){
        User u = new User();
        u.setEmail(userDto.getEmail());
        u.setPassword(userDto.getPassword());
        User savedUser = userRepository.save(u);
        return savedUser;
    }
}
