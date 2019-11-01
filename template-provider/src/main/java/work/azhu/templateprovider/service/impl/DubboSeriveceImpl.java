package work.azhu.templateprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import work.azhu.templateapi.model.User.User;
import work.azhu.templateapi.service.DubboService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Azhu
 * @Date 2019/11/1 16:57
 * @Description dubbo和springcloud中的feign不同，dubbo暴露的是service层接口
 */
@Service(version = "${demo.service.version}")
public class DubboSeriveceImpl implements DubboService {

    @Value("${server.port}")
    Integer port;
    public String sayHello(String name) {
        return "微服务端口号："+port+"Hello, " + name + " (from Spring Boot)";
    }

    @HystrixCommand
    @Override
    public String welcome() {
        return "这是一个通过zookeeper注册的服务";
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="2000")    })
    @Override
    public User findById(Integer id) {
        User user = new User("scott");
        user.setId(id);
        return user;
    }
    @HystrixCommand
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "Azhu");
        User user2 = new User(2, "朱翁俊");
        User user3 = new User(3, "Left-Behind");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }
}
