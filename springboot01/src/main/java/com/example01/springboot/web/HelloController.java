package com.example01.springboot.web;

import com.example01.springboot.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    基础例子
    使用Thymeleaf模板例子
    统一异常处理例子
 */

//这里只能用@Controller不能用@RestController，后者会直接输出json格式的/index,而不是跳转页面
@Controller
//@RestController
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }
    //当发生错误时，会默认调用spring boot的error映射，不一定需要用到throws Exception

    @RequestMapping("/hi")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";//返回网页名
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
    /*仍未解决*/
    /*
    为何不是???
    @RequestMapping("/json")
    public String json() throws Exception {
        throw new Exception("发生错误2");
    }
     */

}

/*

    @Controller：修饰class，用来创建处理http请求的对象
    @RestController：Spring4之后加入的注解，原来在@Controller中返回json需要@ResponseBody来配合，如果直接用@RestController替代@Controller就不需要再配置@ResponseBody，默认返回json格式。
    @RequestMapping：配置url映射

 */
