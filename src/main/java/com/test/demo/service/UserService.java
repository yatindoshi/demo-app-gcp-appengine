package com.test.demo.service;

import com.test.demo.domain.User;
import com.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUser(Integer id) {
        return userRepository.findById(id).get();
    }
}
