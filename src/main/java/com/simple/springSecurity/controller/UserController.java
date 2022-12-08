package com.simple.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/user")
    public String user(Principal principal){
        return "hi dear user "+principal.getName();

    }

    @GetMapping("/admin")
    public String admin(Principal principal){
        return "hi dear admin "+principal.getName();

    }
}
