package com.zc.swagger.controller;

import com.zc.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    //  只要我们的接口中，返回值中存在实体类，他就会被扫描到Swagger中
    @ApiOperation("Hello控制类")
    @PostMapping("/user")
    public User user() {
        return new User();
    }
}
