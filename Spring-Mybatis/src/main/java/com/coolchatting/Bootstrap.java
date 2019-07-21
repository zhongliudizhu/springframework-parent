package com.coolchatting;

import com.coolchatting.config.DataSourceConfig;
import com.coolchatting.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Bootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new
                AnnotationConfigApplicationContext();
        applicationContext.register(DataSourceConfig.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("userDao", UserDao.class));
    }
}
