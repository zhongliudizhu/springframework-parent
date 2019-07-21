package com.coolchatting;

import com.coolchatting.beanfactorypostprocessor.MyBeanDefinitionPostProcessor;
import com.coolchatting.conf.BeansConf;
import com.coolchatting.domain.Order;
import com.coolchatting.domain.User;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
public class Bootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeansConf.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean(Order.class));
        System.out.println(applicationContext.getBean(User.class));


    }
}
