package com.service.user;

import com.dao.Iuserdao;
import com.pojo.User;
import com.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ld on 2019/3/26.
 */
@Service
public class Userservice implements Iuserservice{

    @Resource
    Iuserdao iuserdao;
    @Override
    public User login(User user) {
        return iuserdao.login(user);
    }
    @Override
    public int add(User user){
        return  iuserdao.add(user);
    }
    @Override
    public int batch(List<User> users){
        return  iuserdao.batch(users);
    }
    public Result list(User user){
        Result result=new Result(iuserdao.list(user),user.getPageNumber(),iuserdao.count(user),user.getPageSize() );
        return result;
    }
}
