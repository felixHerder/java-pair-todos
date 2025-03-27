package com.felixherder.todo.controller;

import com.felixherder.todo.model.Todo;
import com.felixherder.todo.model.User;
import com.felixherder.todo.service.AdminService;
import com.felixherder.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final AdminService adminService;

    @GetMapping("/viewUsers")
    public String getUsers(Model model){
        model.addAttribute("users" , userService.getAllUsers());
        return "usersList";
    }

    @GetMapping("/createTask")
    public String getCreateTaskPage(Model model, @RequestParam Integer userId) {
        model.addAttribute("userId", userId);
        model.addAttribute("todo", new Todo());

        return "createTask";
    }

    @PostMapping
    public String createTask(@ModelAttribute Todo todo, @RequestParam Integer userId) {
        User user = userService.findById(userId);
        adminService.addTaskToUser(user, todo);
        return "redirect:/admin/viewUsers";
    }
}
