package com.micro.user.service.services;

import com.micro.user.service.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User updateUser(User user);

    String deleteUserById(String userId);

    User getUserById(String userId);

}
