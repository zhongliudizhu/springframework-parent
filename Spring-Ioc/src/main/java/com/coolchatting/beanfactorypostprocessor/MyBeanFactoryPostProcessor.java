package com.coolchatting.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            if (s.equals("user")) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(s);
                MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
                System.out.println(propertyValues);
            }
        }
    }
}
