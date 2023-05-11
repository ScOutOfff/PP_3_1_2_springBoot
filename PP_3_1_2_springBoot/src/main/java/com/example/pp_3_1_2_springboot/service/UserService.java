package com.example.pp_3_1_2_springboot.service;

import com.example.pp_3_1_2_springboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUserList();
    void add(User user);
//    void editUser(int id, User user);
    User getUserById(int id);
    void delete(int id);
}
