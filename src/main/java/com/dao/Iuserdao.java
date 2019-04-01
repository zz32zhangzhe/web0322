package com.dao;

import com.pojo.User;

import java.util.List;

/**
 * Created by ld on 2019/3/26.
 */
public interface Iuserdao {
    User login(User user);
    int add(User user);
    int batch(List<User> users);
    List<User> list(User user);
    int count(User user);
}
