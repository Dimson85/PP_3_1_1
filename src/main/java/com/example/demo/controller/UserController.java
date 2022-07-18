package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;



//
//    @GetMapping
//    public String homePage(){
//        return "homePage";
//    }
//
//


}
