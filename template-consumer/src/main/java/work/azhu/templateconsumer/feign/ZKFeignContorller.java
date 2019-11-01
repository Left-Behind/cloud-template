package work.azhu.templateconsumer.feign;

import com.example.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ZKFeignContorller {

    @Autowired
    private DiscoveryClient discovery;

    @Resource
    private ZKFeignHystrixClient zkFeignHystrixClient;

    @RequestMapping("/feign")
    public ServiceInstance feign() {
        return discovery.getLocalServiceInstance();
    }

    @RequestMapping("/feign/welcome")
    public String welcome() {
        return zkFeignHystrixClient.welcome();
    }

    @RequestMapping("/feign/hello/{userName}")
    public String hello(@PathVariable String userName) {
        return zkFeignHystrixClient.hello(userName);
    }

    @RequestMapping(value = "/feign/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Integer id) {
        return zkFeignHystrixClient.findById(id);
    }

    @RequestMapping(value = "/feign/findAll", method = RequestMethod.GET)
    public List<User> findAll() {
        return zkFeignHystrixClient.findAll();
    }

}
