package com.example.spring08.Task;

/*
    设置定时任务 每五秒输出一次当前时间
 */

/*
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)//定义每过5秒执行
    public void reportCurrentTime(){
        System.out.println("现在时间:" + dateFormat.format(new Date()));
    }
}
*/

/*
    @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
    @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
    @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
    @Scheduled(cron="") ：通过cron表达式定义规则
 */