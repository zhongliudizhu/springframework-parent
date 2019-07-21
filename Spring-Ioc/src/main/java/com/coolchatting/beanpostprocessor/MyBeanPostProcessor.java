package com.coolchatting.beanpostprocessor;

import com.coolchatting.domain.Order;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("进入" + beanName + "的前置处理方法");
        Order order = null;
        if (beanName.equals("order") && bean instanceof Order) {
            order = (Order) bean;
            order.setAmount(4567.3);
            order.setOrderId(12);
            return order;
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("进入" + beanName + "的后置处理方法");
        return bean;
    }
}
