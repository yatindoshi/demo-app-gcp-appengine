package com.test.demo.web;

import com.test.demo.domain.User;
import com.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/wish")
    public String wish(){
        return "Hello";
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User searchUser(@PathVariable("id") Integer id){
        return userService.findUser(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}
