package com.example.springboot02.domain;

/*
        创建一个User实体，包含id（主键）、name（姓名）、age（年龄）属性，通过ORM框架其会被映射到数据库表中，
        由于配置了hibernate.hbm2ddl.auto，在应用启动的时候框架会自动去数据库中创建对应的表。
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {
    @Id//用于声明一个实体类的属性映射为数据库的主键列
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //用于标注主键的生成策略，通过strategy 属性指定
    //默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略：
    // SqlServer对应identity，MySQL 对应 auto increment。
    private Long id;

    //即Hibernate映射到数据库的相关成员 标识实体类中属性与数据表中字段的对应关系
    //@Column用来定义该成员的属性
    @Column(nullable = false, length = 5)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public User() {

    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
