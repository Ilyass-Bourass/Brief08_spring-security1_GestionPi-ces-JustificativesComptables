package com.alamane.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api")

public class UserController {
    @GetMapping("/comptable")
    public String test(){
        return "test comptable";
    }

    @GetMapping("/societe")
    public String testAdmin(){
        return "test societe";
    }

}
