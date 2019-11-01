package work.azhu.templateconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import work.azhu.templateapi.model.User.User;
import work.azhu.templateapi.service.DubboService;

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

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return dubboService.sayHello(name);
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return dubboService.welcome();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Integer id) {
        return dubboService.findById(id);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<User> findAll() {
        return dubboService.findAll();
    }

}
