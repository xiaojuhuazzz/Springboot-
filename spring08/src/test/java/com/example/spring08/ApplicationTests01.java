package com.example.spring08;

import com.example.spring08.Task.Task;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests01 {

    @Autowired
    private Task task;

    @Test
    public void test() throws Exception {

        long start = System.currentTimeMillis();

        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

        /*
        //若超时 则抛出异常
        Future<String> futureResult = task.doTaskOne();
        String result = futureResult.get(5, TimeUnit.SECONDS);
        log.info(result);
        */
    }
}
/*
    输出为：
    2018-07-22 16:33:28.196  INFO 15766 --- [ taskExecutor-1] com.example.spring08.Task.Task           : 开始做任务一
    2018-07-22 16:33:28.196  INFO 15766 --- [ taskExecutor-3] com.example.spring08.Task.Task           : 开始做任务三
    2018-07-22 16:33:28.196  INFO 15766 --- [ taskExecutor-2] com.example.spring08.Task.Task           : 开始做任务二
    2018-07-22 16:33:29.477  INFO 15766 --- [ taskExecutor-2] com.example.spring08.Task.Task           : 完成任务二，耗时：1280毫秒
    2018-07-22 16:33:37.452  INFO 15766 --- [ taskExecutor-1] com.example.spring08.Task.Task           : 完成任务一，耗时：9255毫秒
    2018-07-22 16:33:37.712  INFO 15766 --- [ taskExecutor-3] com.example.spring08.Task.Task           : 完成任务三，耗时：9516毫秒
    任务全部完成，总耗时：10005毫秒
 */

/*
    测试同步输出例子
 */
/*
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests01 {

    @Autowired
    private Task task;

    @Test
    public void test() throws Exception{
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }
}
*/
/*
    输出为：
    开始做任务一
    完成任务一，耗时：9160毫秒
    开始做任务二
    完成任务二，耗时：3908毫秒
    开始做任务三
    完成任务三，耗时：5111毫秒
 */


