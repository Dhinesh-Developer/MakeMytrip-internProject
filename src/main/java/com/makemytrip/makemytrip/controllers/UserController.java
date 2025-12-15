package com.makemytrip.makemytrip.controllers;

import com.makemytrip.makemytrip.models.Users;
import com.makemytrip.makemytrip.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Users login(@RequestParam String email,@RequestParam String password){
        return userService.login(email,password);
    }

    @PostMapping("/signup")
    public ResponseEntity<Users> signUp(@RequestBody Users users){
        return ResponseEntity.ok(userService.signUp(users));
    }

}
