package com.coolchatting;

import com.coolchatting.api.HelloService;
import com.coolchatting.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(SpringConfig.class);
        HelloService bean = applicationContext.getBean(HelloService.class);
        System.out.println(bean.sayHello("======="));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("01", "jjjj");

    }
}
