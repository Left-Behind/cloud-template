package work.azhu.templateconsumer.service.impl;

import org.springframework.stereotype.Component;
import work.azhu.templateconsumer.service.TestInterface;

@Component
public class TestInterfaceImp implements TestInterface {


    @Override
    public String hello(String userName) {
        return "微服务template-provider被熔断，调用本地登录，欢迎用户："+userName+"登录";
    }
}
