package com.simple.springSecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/free")
    public String free(Principal principal){
        return "you are in free page";

    }
    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String user(Principal principal){
        return "hi dear user "+principal.getName();

    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String admin(Principal principal){
        return "hi dear admin "+principal.getName();

    }
}
