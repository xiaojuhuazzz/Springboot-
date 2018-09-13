package com.example.spring06;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests01 {

    private Logger logger = LogManager.getLogger(getClass());

    @Test
    public void contextLoads() {

        logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");
    }
}

/*
    输出为:
    2018-07-21 11:18:59.985 DEBUG yjk-GL72M-7REX --- [           main] c.e.s.ApplicationTests01                 : Debugging log
    2018-07-21 11:18:59.985  INFO yjk-GL72M-7REX --- [           main] c.e.s.ApplicationTests01                 : Info log
    2018-07-21 11:18:59.985  WARN yjk-GL72M-7REX --- [           main] c.e.s.ApplicationTests01                 : Hey, This is a warning!
    2018-07-21 11:18:59.985 ERROR yjk-GL72M-7REX --- [           main] c.e.s.ApplicationTests01                 : Oops! We have an Error. OK
    2018-07-21 11:18:59.986 FATAL yjk-GL72M-7REX --- [           main] c.e.s.ApplicationTests01                 : Damn! Fatal error. Please fix me.
    2018-07-21 11:18:59.989  INFO yjk-GL72M-7REX --- [       Thread-2] o.s.w.c.s.GenericWebApplicationContext   : Closing org.springframework.web.context.support.GenericWebApplicationContext@2b175c00: startup date [Sat Jul 21 11:18:58 CST 2018]; root of context hierarchy

 */