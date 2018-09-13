package com.example.spring08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/*
    定时与异步任务:
    1.使用@Scheduled创建定时任务:实现每过5秒输出一下当前时间
    2.使用@Async实现异步调用
    3.自定义线程池
    4.线程池的优雅关闭
 */

@SpringBootApplication
@EnableScheduling//启用定时任务的配置
//@EnableAsync//启动异步的配置
public class Spring08Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring08Application.class, args);
    }

    @EnableAsync
    @Configuration
    class TaskPoolConfig {

        @Bean("taskExecutor")
        public Executor taskExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(10);//核心线程数10
            executor.setMaxPoolSize(20);//最大线程数20
            executor.setQueueCapacity(200);//缓冲队列200
            executor.setKeepAliveSeconds(60);//允许线程的空闲时间60秒
            executor.setThreadNamePrefix("taskExecutor-");//线程池名的前缀
            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            //线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，
            // 该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务

            executor.setWaitForTasksToCompleteOnShutdown(true);
            //设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean，这样这些异步任务的销毁就会先于Redis线程池的销毁
            executor.setAwaitTerminationSeconds(60);
            //该方法用来设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
            return executor;
        }
    }
}
