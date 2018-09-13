package com.example.spring06.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Order(1)
@Component
public class WebLogAspect {

    private Logger logger = LogManager.getLogger(getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.example.spring06.web..*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        //接受到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    //记录请求返回的对象
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        //处理完请求，返回内容
        logger.info("RESPONSE : " + ret);

        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }
}

/*
    输入：
    http://localhost:8080/hello?name=didi
    输出:
    2018-07-21 11:36:37.231  INFO yjk-GL72M-7REX --- [nio-8080-exec-1] c.e.s.a.WebLogAspect
    : URL : http://localhost:8080/hello
    : HTTP_METHOD : GET
    : IP : 127.0.0.1
    : CLASS_METHOD : com.example.spring06.web.HelloController.hello
    : ARGS : [didi]
    : RESPONSE : Hello didi
    : SPEND TIME : 4

*/

/*
    功能：统计请求的处理时间
    方法：引入ThreadLocal对象
    ThreadLocal<Long> startTime = new ThreadLocal<>();
    startTime.set(System.currentTimeMillis());
    logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
 */

/*
    AOP切面的优先级设置
    @Order(i)注解来标识切面的优先级。i的值越小，优先级越高
    注：
    在切入点前的操作，按order的值由小到大执行
    在切入点后的操作，按order的值由大到小执行
 */
