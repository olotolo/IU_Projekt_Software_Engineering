package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("")
    public String getHome() {
        return "/home";
    }

    @GetMapping("/profile")
    public String profile() {
        return "/profile";
    }

    @GetMapping("/error")
    public String getError() {
        return "/error";
    }
}
