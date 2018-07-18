package com.xiongqi.securitydemo.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private String name;

    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User() {

    }
}
