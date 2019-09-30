package work.azhu.templatezipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

@EnableZipkinServer
@EnableEurekaClient
@SpringBootApplication
public class TemplateZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateZipkinApplication.class, args);
    }

}
