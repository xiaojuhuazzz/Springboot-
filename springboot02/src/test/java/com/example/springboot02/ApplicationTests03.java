package com.example.springboot02;

import com.example.springboot02.domain.User;
import com.example.springboot02.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

//我们单元测试为了保证每个测试之间的数据独立，会使用@Rollback注解让每个单元测试都能在结束时回滚。
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests03 {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional//声明一个函数需要被事务管理
    public void test() throws Exception {

        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHHHHHHHHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));

    }
}
/*

    当用多个数据源， 需要在声明事务时，指定不同的事务管理器
    只需要通过value属性指定配置的事务管理器名 @Transactional(value="transactionManagerPrimary")

    隔离级别 例@Transactional(isolation = Isolation.DEFAULT)
    隔离级别是指若干个并发的事务之间的隔离程度，与我们开发时候主要相关的场景包括：脏读取、重复读、幻读

    传播行为 例@Transactional(propagation = Propagation.REQUIRED)
    所谓事务的传播行为是指，如果在开始当前事务之前，一个事务上下文已经存在，此时有若干选项可以指定一个事务性方法的执行行为。
    属性有蛮多的 具体看解析：http://blog.didispace.com/springboottransactional/

 */
