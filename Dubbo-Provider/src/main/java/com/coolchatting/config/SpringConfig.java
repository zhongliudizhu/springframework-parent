package com.coolchatting.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.coolchatting")
@Import({DubboConfig.class})
public class SpringConfig {
}
