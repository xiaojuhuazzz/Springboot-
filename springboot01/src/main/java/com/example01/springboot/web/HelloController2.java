package com.example01.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
    使用Spring Security进行安全控制  例子
 */

@Controller
public class HelloController2 {

    @RequestMapping("/index2")
    public String index() {
        return "index2";
    }

    @RequestMapping("/hello2")
    public String hello() {
        return "hello2";
    }

    @RequestMapping(value = "/login2", method = RequestMethod.GET)
    public String login() {
        return "login2";
    }
}
