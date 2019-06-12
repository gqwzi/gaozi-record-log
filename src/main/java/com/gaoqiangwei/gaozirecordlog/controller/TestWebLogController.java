package com.gaoqiangwei.gaozirecordlog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaoqiangwei.gaozirecordlog.aspect.WebLog;
import com.gaoqiangwei.gaozirecordlog.entity.User;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>TestWebLogController
 * </p>
 *
 * @author gaoqiangwei
 * @date 2019/6/12 16:05
 **/
@Slf4j
@RestController
@RequestMapping("/webLog")
public class TestWebLogController {

    @WebLog(description = "用户登录")
    @PostMapping("/login")
    public String  login(@RequestBody User user){
        log.info("user login");
        return "login success";
    }
}