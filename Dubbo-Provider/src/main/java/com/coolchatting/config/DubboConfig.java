package com.coolchatting.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.coolchatting.seviceImpl")
@PropertySource(value = "classpath:spring/dubboProvider.properties")
public class DubboConfig {


}
