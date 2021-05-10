package com.test.demo.web;

import com.test.demo.domain.User;
import com.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/wish")
    public String wish(){
        return "Hello";
    }

    @GetMapping("/users/{id}")
    public User searchUser(@PathVariable("id") Integer id){
        return userService.findUser(id);
    }
}
