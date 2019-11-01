package work.azhu.templateapi.service;

import work.azhu.templateapi.model.User.User;

import java.util.List;

/**
 * @Author Azhu
 * @Date 2019/11/1 17:06
 * @Description
 */
public interface DubboService {

    String sayHello(String name);

    String welcome();

    User findById(Integer id);

    List<User> findAll();
}
