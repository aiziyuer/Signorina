package com.aiziyuer.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 应用入口文件
 */
public class App {

    public static void main(String[] args) {

        new ClassPathXmlApplicationContext("applicationContext.xml");

    }

}
