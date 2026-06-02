package com.eventsystem.service;

import com.eventsystem.model.User;
import com.eventsystem.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventsystem.security.JwtUtil;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user){

        return userRepository.save(user);
    }

    public String login(
            String email,
            String password){

        User user=
                userRepository
                        .findByEmail(email);

        if(user==null){

            return "User Not Found";
        }

        if(user.getPassword()==null){

            return "Password Missing";
        }

        if(!user.getPassword()
                .equals(password)){

            return "Invalid Password";
        }

        return JwtUtil
                .generateToken(email);
    }
}