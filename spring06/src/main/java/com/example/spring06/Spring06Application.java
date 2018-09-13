package com.example.spring06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    日志管理
    1.默认日志工具（logback）
    2.使用log4j记录日志
    (似乎2.0不支持log4j 只能用log4j2 然而log4j2只能用.xml文件 所以很难去操作其他东西 具体看代码就好)
    3.Aop功能
    4.使用log4j实现http请求日志入mongodb
    (log4j提供的输出器实现自Appender接口，要自定义appender输出到MongoDB，只需要继承AppenderSkeleton类，并实现几个方法即可完成)
 */

//当加入AOP依赖时，已默认开启AOP 即不需要加@EnableAspectJAutoProxy
@SpringBootApplication
public class Spring06Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring06Application.class, args);
    }
}

/*
    1.默认日志工具（logback）
    如：2018-07-21 09:31:08.318  INFO 3091 --- [           main] c.example.spring06.Spring06Application   : Starting Spring06Application on yjk-GL72M-7REX with PID 3091 (started by yjk in /home/yjk/桌面/project/spring06)
       时间日期                日志级别 进程ID 分隔符   线程名        Logger名 — 通常使用源代码的类名                日志内容
       即 时间 日记级别 进程ID --- [线程名] Logger名（源代码类名） ： 日志内容

    3.AOP注释
    @Aspect  注解将一个java类定义为切面类
    @Pointcut  定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
            根据需要在切入点不同位置的切入内容
    @Before  在切入点开始处切入内容
    @After  在切入点结尾处切入内容
    @AfterReturning  在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
    @Around  在切入点前后切入内容，并自己控制何时执行切入点自身的内容
    @AfterThrowing  用来处理当切入内容部分抛出异常之后的处理逻辑

 */