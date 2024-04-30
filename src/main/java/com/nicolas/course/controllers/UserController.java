package com.nicolas.course.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolas.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Nicolas", "nicolas@email.com", "11986077565", "2712202");

        return ResponseEntity.ok(u);
    }
}
