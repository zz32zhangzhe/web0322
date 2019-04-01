package com.service.user;

import com.pojo.User;
import com.util.Result;

import java.util.List;

/**
 * Created by ld on 2019/3/26.
 */
public interface Iuserservice {
    User login(User user);
    int add(User user);
    int batch(List<User> users);
    Result list(User user);
}
