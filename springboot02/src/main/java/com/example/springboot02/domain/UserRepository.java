package com.example.springboot02.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/*
        该接口本身已经实现了创建（save）、更新（save）、删除（delete）、查询（findAll、findOne）等基本操作的函数，
        因此对于这些基础操作的数据访问就不需要开发者再自己定义。
 */


@CacheConfig(cacheNames = "users")//增加缓存配置注解
//针对User实体创建对应的Repository接口实现对该实体的数据访问
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable(key = "#p0")
        //Spring-data-jpa的一大特性：通过解析方法名创建查询。
    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    //使用@Query注解来创建查询，并通过类似“:name”来映射@Param指定的参数
    @Query("from User u where u.name= :name")
    User findUser(@Param("name") String name);

    @CachePut(key = "#p0.name")
    User save(User user);

}

/*
    @CacheConfig(cacheNames = "users")
    配置了该数据访问对象中返回的内容将存储于名为users的缓存对象中，我们也可以不使用该注解，直接通过@Cacheable自己配置缓存集的名字来定义

    @Cacheable
    配置了findByName函数的返回值将被加入缓存,同时在查询时，会先从缓存中获取，若不存在才再发起对数据库的访问。

    @Cacheable参数：
    key：缓存对象存储在Map集合中的key值，非必需，缺省按照函数的所有参数组合作为key值，
    若自己配置需使用SpEL表达式，比如：@Cacheable(key = "#p0")
    condition 等等

    具体其他注释：http://blog.didispace.com/springbootcache1/
 */