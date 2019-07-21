package com.coolchatting.spring.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.InitializingBean;

public class MapperFactoryBeanSupport implements InitializingBean {
    private SqlSession sqlSession;

    public SqlSession getSqlSession() {
        return this.sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void afterPropertiesSet() throws Exception {


    }
}
