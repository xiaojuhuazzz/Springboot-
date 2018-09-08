package com.example.springboot02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
    1.使用JdbcTemplate
    2.使用Spring-data-jpa简化数据访问层
    3.使用事务管理
    4.开启hibernate对sql语句的打印
    5.cache缓存功能的试用
    6.使用EhCache进行缓存管理//已删除
    7.使用Redis做集中式缓存
 */
@SpringBootApplication
@EnableCaching//注解开启缓存功能
public class Springboot02Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02Application.class, args);
    }
}
