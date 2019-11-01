package work.azhu.templateprovider.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import work.azhu.templateapi.model.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Azhu
 * @date 2019/8/22 18:01
 */
@RestController
public class BaseController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/{userName}")
    public String hello(@PathVariable String userName)
    {
        return "微服务名称: template-provider,提供者，端口号："+port+" \n欢迎用户："+userName+"登录";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "这是一个通过zookeeper注册的服务";
    }
    //url地址和@GetMapping("/{userName}")重复了
    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)*/
    public User findById(Integer id) {
        User user = new User("测试者");
        user.setId(id);
        return user;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "scott");
        User user2 = new User(2, "ameizi");
        User user3 = new User(3, "stev");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }
}
