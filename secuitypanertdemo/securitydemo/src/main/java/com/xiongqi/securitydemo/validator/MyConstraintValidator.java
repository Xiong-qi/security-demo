package com.xiongqi.securitydemo.validator;


import com.xiongqi.securitydemo.web.service.HellowService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator  implements ConstraintValidator<MyConstraint,Object> {

    @Autowired
    private HellowService hellowService;

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("init myConstraint !!");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        hellowService.greeting("tom");
        System.out.println(value);

        return false;
    }
}
