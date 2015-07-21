package com.aiziyuer.app;

import com.aiziyuer.app.fiberLink.IFiberService;
import com.aiziyuer.app.framework.util.ServiceLocator;

import lombok.extern.log4j.Log4j2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 应用入口文件
 */
@Log4j2
public class App {

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

        log.info("spring init start.");
        long currentTime = System.currentTimeMillis();
        
        new ClassPathXmlApplicationContext("applicationContext.xml");
        
        log.info(String.format("spring init end, cost(%ss).", System.currentTimeMillis() - currentTime));

        IFiberService fiberService = ServiceLocator.getInstance().getService("fiberService");
        fiberService.sayHello();

    }
}
