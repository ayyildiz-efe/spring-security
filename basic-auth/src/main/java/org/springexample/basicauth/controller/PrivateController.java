package org.springexample.basicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping
    private String helloWorldPrivate(){
        return "Hello World! from private endpoint";
    }

    @GetMapping("/user")
    private String helloWorldPrivateUser(){
        return "Hello World! from private endpoint for user";
    }

    @GetMapping("/admin")
    private String helloWorldPrivateAdmin(){
        return "Hello World! from private endpoint for admin";
    }
}
