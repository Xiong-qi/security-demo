package com.xiongqi.securitydemo.web.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.xiongqi.securitydemo.validator.MyConstraint;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

@Data
@ToString
public class User {

    public interface UserSimpleView{};

    public interface UserDetailView extends UserSimpleView{};

    private String id;

    @JsonView(UserSimpleView.class)
    @MyConstraint(message = "这是一个测试")
    private String name;

    @Past(message = "生日为过去时间")
    private Date birthday;

    @JsonView(UserDetailView.class)
    @NotBlank(message = "密码不能为空")
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User() {

    }
}
