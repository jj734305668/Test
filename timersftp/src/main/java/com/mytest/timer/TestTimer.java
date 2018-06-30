package com.mytest.timer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author 贾_杰
 * @Date 2018/6/29
 **/
@EnableScheduling
@Component
@ComponentScan("com.mytest.testtimer")
public class TestTimer {

    @Scheduled(cron = "0/5 * * * * ?")
    public void timer(){
        System.out.println("running........");
    }

    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestTimer.class);
    }

}
