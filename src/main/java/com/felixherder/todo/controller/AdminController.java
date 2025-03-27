package com.felixherder.todo.controller;

import com.felixherder.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/viewUsers")
    public String getUsers(Model model){
        model.addAttribute("users" , userService.getAllUsers());
        return "usersList";
    }


}
