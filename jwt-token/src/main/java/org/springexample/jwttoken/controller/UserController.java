package org.springexample.jwttoken.controller;

import lombok.extern.slf4j.Slf4j;
import org.springexample.jwttoken.dto.AuthRequest;
import org.springexample.jwttoken.dto.CreateUserRequest;
import org.springexample.jwttoken.model.User;
import org.springexample.jwttoken.service.JwtService;
import org.springexample.jwttoken.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/auth")
@Slf4j
public class UserController {

    private final UserService userService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Security JWT";
    }

    @PostMapping("/addNewUser")
    public User addNewUser(@RequestBody CreateUserRequest user) {
        return userService.createUser(user);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.username(), user.password()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(user.username());
        }
        log.info("Authentication failed ! invalid username or password : {}", user.username());
        throw new UsernameNotFoundException("Invalid username or password");
    }

    @GetMapping("/user")
    public String getUserString(){
        return "Get String with User Role !";
    }

    @GetMapping("/admin")
    public String getAdminString(){
        return "Get String with Admin Role !";
    }
}
