package com.coolchatting.spring.mybatis;

import org.springframework.beans.factory.FactoryBean;


public class BiMapperFactoryBean<T> extends MapperFactoryBeanSupport implements FactoryBean<T> {
    private Class<T> mapperInterface;

    public BiMapperFactoryBean(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T getObject() throws Exception {
        return getSqlSession().getMapper(this.mapperInterface);
    }

    public Class<?> getObjectType() {
        return this.mapperInterface;
    }

    public boolean isSingleton() {
        return true;
    }
}
