package work.azhu.templateconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import work.azhu.templateconsumer.service.impl.TestInterfaceImp;

/**
 * @author Azhu
 * @date 2019/8/22 18:39
 */
@FeignClient(name= "template-provider",fallback = TestInterfaceImp.class)
public interface TestInterface {

    @GetMapping("/hello/{userName}")
    String hello(@PathVariable(name = "userName") String userName);
}
