package com.felixherder.todo.service;

import com.felixherder.todo.model.Todo;
import com.felixherder.todo.model.User;
import com.felixherder.todo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepo userRepo;


    public void addTaskToUser(User user, Todo todo) {
        String userName = user.getUsername();
        userRepo.findByUsername(userName).getTodoList().add(todo);
    }

}
