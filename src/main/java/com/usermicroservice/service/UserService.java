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

    public User createUser(String username, String email) {
        User user = User.builder().username(username).email(email).build();
        userRepo.save(user);
        return user;
    }

    public User getUserById(int id) {
        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new RuntimeException("Not found");
    }
}

