package work.azhu.templatehystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class TemplateHystrixdashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateHystrixdashboardApplication.class, args);
    }

}
