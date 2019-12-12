package work.azhu.templateconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import work.azhu.templateapi.model.User.User;
import work.azhu.templateapi.service.DubboService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Azhu
 * @Date 2019/11/1 17:03
 * @Description
 */
@RestController
public class DubboController {

    @Reference(version = "${demo.service.version}")
    private DubboService dubboService;


    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return dubboService.sayHello(name);
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/welcome")
    public String welcome() {
        return dubboService.welcome();
    }

    @HystrixCommand(fallbackMethod = "fallbackUser")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Integer id) {
        return dubboService.findById(id);
    }

    @HystrixCommand(fallbackMethod = "fallbackList")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<User> findAll() {
        return dubboService.findAll();
    }

    public String fallback(){

        return "Hystrix fallback-----------抱歉，某个服务被熔断了";

    }
    public String fallback(String name){

        return "Hystrix fallback-----------抱歉，某个服务被熔断了";

    }
    public List<User> fallbackList(){
        System.out.println("Hystrix fallback-----------抱歉，某个服务被熔断了");
        return new ArrayList<User>();

    }
    public User fallbackUser(Integer id){
        System.out.println("Hystrix fallback-----------抱歉，某个服务被熔断了");
        return new User();

    }
}
