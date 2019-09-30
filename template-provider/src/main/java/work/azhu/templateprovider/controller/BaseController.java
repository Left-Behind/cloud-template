package work.azhu.templateprovider.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Azhu
 * @date 2019/8/22 18:01
 */
@RestController
public class BaseController {

    @GetMapping("/hello/{userName}")
    public String hello(@PathVariable String userName)
    {
        return "微服务名称: template-provider,提供者，欢迎用户："+userName+"登录";
    }


}
