package com.example.demo.controller;


import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @GetMapping("/userpage")
    public String userPage(Principal principal, Model model){
        model.addAttribute("user", userService.loadUserByUsername(principal.getName()));
        return "userPage";
    }
}
