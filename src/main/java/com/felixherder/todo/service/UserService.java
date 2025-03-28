package com.felixherder.todo.service;

import com.felixherder.todo.model.User;
import com.felixherder.todo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User findById(Integer id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("no user found"));
    }

}
