package com.usermicroservice.service;


import com.usermicroservice.model.User;
import com.usermicroservice.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    User saveUser(int userId, String username, String email) {
        User user = new User(userId, username, email);
        return userRepo.save(user);
    }

    Optional<User> findById(int id) {
        return userRepo.findById(id);
    }
}

