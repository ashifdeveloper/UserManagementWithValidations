package com.geekster.UserManagement.service;

import com.geekster.UserManagement.model.User;
import com.geekster.UserManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getAlLUsers() {
        return userRepo.getUsers();
    }

    public String createUsers(List<User> users) {
        List<User> originalList = getAlLUsers();
        originalList.addAll(users);
        return "New Users Added";
    }

    public String createUser(User user) {
        List<User> originalList = getAlLUsers();
        originalList.add(user);
        return "New User Added";

    }

    public String updateUserInfo(Integer userId,User updateUser) {
        for (User info : userRepo.getUsers()) {
            if (info.getUserId().equals(userId)) {
                info.setUserName(updateUser.getUserName());
                info.setUserDOB(updateUser.getUserDOB());

                info.setEmail(updateUser.getEmail());
                info.setPhoneNumber(updateUser.getPhoneNumber());
                info.setDate(updateUser.getDate());
                return "User updated for UserId " + userId;
            }
        }
        return "User not found for userId: " + userId;
    }

    public String deleteUserInfo(Integer userId) {
        for(User user : userRepo.getUsers()){
            if(user.getUserId().equals(userId)){
                userRepo.removeUser(user);
                return "User deleted for userId" + userId;
            }
        }
        return "user:" + userId + "not deleted as it does not exist";

    }

    public List<User> getUser(Integer userId) {
        List<User> userIdInfo = new ArrayList<>();


        for (User info : userRepo.getUsers()) {

            if (info.getUserId().equals(userId)) {
                userIdInfo.add(info);


            }
        }
        return userIdInfo;

    }
}
