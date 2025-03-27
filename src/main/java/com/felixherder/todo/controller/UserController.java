package com.felixherder.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UserController {


    @GetMapping("/")
    public String getTodos(Model model, Authentication authenticator){
        model.addAttribute("username", authenticator.getName());
        return "todo-list";
    }



}
