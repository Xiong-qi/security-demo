package com.xiongqi.securitydemo.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.xiongqi.securitydemo.web.domain.User;
import com.xiongqi.securitydemo.web.query.UserQuery;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  xq
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     *   get    (/user)            查询所有
     *   get    (/user/{id})       查询单个
     *   post   (/user)            新增
     *   put    (/user/{id})       修改
     *   delete (/user/{id})       删除用户
     *
     */

    @DeleteMapping("/{id:\\d+}")
    public boolean delete(@PathVariable(value = "id") String id){
        System.out.println(id);

        return true;
    }



    @PutMapping("/{id:\\d+}")
    public User updata(@Valid @RequestBody  User user, BindingResult errors){

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error-> {
//                FieldError fieldError= (FieldError)error;
//                String message=fieldError.getField()+" "+error.getDefaultMessage();
                System.out.println(error.getDefaultMessage());
            }
            );
        }
        System.out.println(user);

        user.setId("1");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody  User user){

        System.out.println(user);

        user.setId("1");
        return user;
    }

    @GetMapping
    @JsonView(User.UserDetailView.class)
    public List<User> query(UserQuery userQuery){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("xq","123456"));
        users.add(new User("xq1","123456"));
        users.add(new User("xq2","123456"));

        System.out.println(userQuery);
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getUserInfo(@PathVariable(value = "id") String id){
        System.out.println(id);
        return new User("tom","123456");
    }

}
