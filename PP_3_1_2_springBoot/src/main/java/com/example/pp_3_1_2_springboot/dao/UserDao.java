package com.example.pp_3_1_2_springboot.dao;


import com.example.pp_3_1_2_springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    void add(User user);

    User getUserById(int id);

    void editUser(int id, User user);

    void delete(int id);
}
