package com.coolchatting.conf;

import com.coolchatting.domain.Order;
import com.coolchatting.domain.User;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Configurable
@ComponentScan(basePackages = "com.coolchatting")
@Import(myImport.class)
public class BeansConf {
    @Bean(initMethod = "initUser")
    public User user() {
        return new User(1, "zhangfei", "上海");
    }

}
