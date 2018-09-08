package com.example.springboot02;

import com.example.springboot02.domain.User;
import com.example.springboot02.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests04 {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private CacheManager cacheManager;
    //可使用debug模式运行单元测试，观察cacheManager中的缓存集users以及其中的User对象的缓存加深理解


    @Before
    public void before() {
        userRepository.save(new User("AAA", 10));
    }

    @Test
    public void test() throws Exception {
        User u1 = userRepository.findByName("AAA");
        System.out.println("第一次查询:" + u1.getAge());

        User u2 = userRepository.findByName("AAA");
        System.out.println("第二次查询:" + u2.getAge());
    }
}
/*
    输出：
    Hibernate: insert into user (age, name) values (?, ?)
    Hibernate: select user0_.id as id1_0_, user0_.age as age2_0_, user0_.name as name3_0_ from user user0_ where user0_.name=?
    第一次查询:10
    Hibernate: select user0_.id as id1_0_, user0_.age as age2_0_, user0_.name as name3_0_ from user user0_ where user0_.name=?
    第二次查询:10
 */

/*
    加入cache后的输出：
    Hibernate: insert into user (age, name) values (?, ?)
    Hibernate: select user0_.id as id1_0_, user0_.age as age2_0_, user0_.name as name3_0_ from user user0_ where user0_.name=?
    第一次查询:10
    第二次查询:10
 */

/*
    加入EhCache后 再次debug
    cacheManager的类型变成了EhCacheManager
 */
