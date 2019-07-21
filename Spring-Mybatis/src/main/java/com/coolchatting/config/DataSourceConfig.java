package com.coolchatting.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.coolchatting.annotation.BiMapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.coolchatting")
@BiMapperScan(basePackages = "com.coolchatting.dao")
@PropertySource(value = "classpath:jdbc.properties")
public class DataSourceConfig {
    @Value("${jdbc.userName}")
    private String userName;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }


}
