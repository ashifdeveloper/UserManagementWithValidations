package com.geekster.UserManagement.controller;

import com.geekster.UserManagement.model.User;
import com.geekster.UserManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    //Read
@GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAlLUsers();
    }


    @PostMapping("users")
    public String addUsers(@RequestBody List<User> users){
            return userService.createUsers(users);
    }


    @PostMapping("user")
    public String addUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("getUser/{userId}")
    public List<User> getUser(@PathVariable Integer userId) {

        return userService.getUser(userId);

    }
    @PutMapping("updateUserInfo/{userId}")
    public String updateUserInfo(@PathVariable Integer userId, @RequestBody User updateUser) {
        return userService.updateUserInfo(userId,updateUser);
        }

    @DeleteMapping("deleteUser/{userId}")
    public String deleteUser(@PathVariable Integer userId){

        return userService.deleteUserInfo(userId);
    }



    }



