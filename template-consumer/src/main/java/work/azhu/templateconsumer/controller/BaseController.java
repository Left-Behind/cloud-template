package work.azhu.templateconsumer.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.azhu.templateconsumer.service.TestInterface;

import javax.annotation.Resource;

/**
 * @author Azhu
 * @date 2019/8/22 17:57
 */

@RestController
public class BaseController {

    @Resource
    private TestInterface testInterface;

    @GetMapping("/hello/{userName}")
     public String hello(@PathVariable String userName){
        return "微服务名称：template-consumer 调用其他微服务          \n"+testInterface.hello(userName);
    }

    /**
     * @param userName
     * @return
     */
    @GetMapping("/consumer/{userName}")
    public String consumer(@PathVariable String userName){
        return "微服务名称：template-consumer";
    }
}
