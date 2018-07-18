package com.xiongqi.securitydemo.controller;

import com.xiongqi.securitydemo.domain.User;
import com.xiongqi.securitydemo.query.UserQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  xq
 */
@RestController
public class UserController {


    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> query(UserQuery userQuery){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("xq","123456"));
        users.add(new User("xq1","123456"));
        users.add(new User("xq2","123456"));

        System.out.println(userQuery);
        return users;
    }
}
