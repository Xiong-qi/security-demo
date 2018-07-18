package com.xiongqi.securitydemo.controller;

import com.xiongqi.securitydemo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  xq
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)

    public List<User> query(@RequestParam(value = "username",required = false) String name){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("xq","123456"));
        users.add(new User("xq1","123456"));
        users.add(new User("xq2","123456"));

        return users;
    }
}
