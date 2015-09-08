package com.aiziyuer.app;

import com.aiziyuer.app.ui.view.Main;

import lombok.extern.log4j.Log4j2;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Display;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 应用入口文件<br>
 * 注意:<br>
 * jvm运行SWT于Mac OS上需要加上参数 -XstartOnFirstThread
 */
@Log4j2
public class App {

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

        log.info("spring init start.");
        long currentTime = System.currentTimeMillis();

        new ClassPathXmlApplicationContext("applicationContext.xml");

        log.info(String.format("spring init end, cost(%ss).", System.currentTimeMillis() - currentTime));

        if (args != null && args.length > 0 && "gui".equals(args[0])) {
            final Display display = new Display();
            Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {

                @Override
                public void run() {
                    try {
                        Main window = new Main();
                        window.setBlockOnOpen(true);
                        window.open();
                        Display.getCurrent().dispose();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
