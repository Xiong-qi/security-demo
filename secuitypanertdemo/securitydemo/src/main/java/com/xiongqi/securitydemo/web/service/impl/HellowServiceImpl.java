package com.xiongqi.securitydemo.web.service.impl;

import com.xiongqi.securitydemo.web.service.HellowService;
import org.springframework.stereotype.Service;

@Service
public class HellowServiceImpl  implements HellowService {


    @Override
    public String greeting(String name) {
        return "hello "+name;
    }
}
