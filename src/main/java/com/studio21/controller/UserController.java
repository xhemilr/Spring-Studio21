package com.studio21.controller;

import com.studio21.model.User;
import com.studio21.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping("/user")
    public String addUser(@RequestBody User newUser){
        userService.save(newUser);
        return "User: " + newUser.getName() + " has been added";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteById(id);
        return "User with ID: " + id + " has been deleted";
    }

    @PutMapping("/user/{id}")
    public String updateUser(@RequestBody User user, @PathVariable int id){
        Optional<User> oldUser = userService.findById(id);
        oldUser.ifPresent(value -> {
            value.setAddress(user.getAddress());
            value.setEmail(user.getEmail());
            value.setLastName(user.getLastName());
            value.setName(user.getName());
            value.setPassword(user.getPassword());
            value.setUsername(user.getUsername());
            value.setRoleId(user.getRoleId());
            userService.save(oldUser.get());
        });
        return "User " + user.getName() + " has been updated";
    }
}
