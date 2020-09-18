package com.example.swagger2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author LIFULIN
 **/
@SpringBootApplication
@Slf4j
public class Swagger2Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Swagger2Application.class, args);
        log.info("————————————————启动成功————————————————");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Swagger2Application.class);
    }


}
