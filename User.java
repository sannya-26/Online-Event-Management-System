package com.eventsystem.controller;

import com.eventsystem.model.User;
import com.eventsystem.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventsystem.repository.UserRepository;
import java.util.List;
import com.eventsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(
            @RequestBody User user){

        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password){

        return userService.login(
                email,
                password
        );
    }
    @GetMapping
    public List<User> getUsers(){

        return userRepository.findAll();
    }
    @GetMapping("/email/{email}")
    public User getUserByEmail(
            @PathVariable String email){

        return userRepository
                .findByEmail(email);
    }
}