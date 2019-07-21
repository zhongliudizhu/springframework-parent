package com.coolchatting.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.stereotype.Component;


public class Order implements BeanNameAware, BeanFactoryAware {

    private Integer orderId;
    private Double amount;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                '}';
    }

    public Order() {
        System.out.println(Thread.currentThread().getName() + "调用order的无参构造");

    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    private void initOrder() {
        System.out.println("进入order的init方法");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        int beanDefinitionCount = 0;
        if (beanFactory instanceof AbstractAutowireCapableBeanFactory) {
            ListableBeanFactory factory = (ListableBeanFactory) beanFactory;
            beanDefinitionCount = factory.getBeanDefinitionCount();
        }
        System.out.println("beanDefinitionCount=" + beanDefinitionCount);
    }

    public void setBeanName(String name) {
        System.out.println("BeanName=" + name);
    }


}
