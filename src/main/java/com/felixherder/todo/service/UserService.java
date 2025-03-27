package com.felixherder.todo.service;

import com.felixherder.todo.model.User;
import com.felixherder.todo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

}
