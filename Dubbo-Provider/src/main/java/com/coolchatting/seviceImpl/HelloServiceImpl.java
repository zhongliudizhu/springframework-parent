package com.coolchatting.seviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.coolchatting.api.HelloService;
import org.springframework.stereotype.Component;

@Service(version = "1.0.0", interfaceClass = HelloService.class, interfaceName = "helloServiceImpl")
@Component
public class HelloServiceImpl implements HelloService {

    public String sayHello(String name) {
        return name;
    }
}
