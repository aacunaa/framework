package com.apiframework.framework.controller;


import com.apiframework.framework.exception.ResourceNotFoundException;
import com.apiframework.framework.model.User;
import com.apiframework.framework.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class UserController {


    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        logger.info("allUsers");
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserId(@PathVariable(value = "id") Long userId){
        logger.info("user");
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
    }
}
