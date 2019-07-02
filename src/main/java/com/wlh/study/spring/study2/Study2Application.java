package com.wlh.study.spring.study2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.wlh.study")
@EnableJpaRepositories(basePackages = "com.wlh.study")
@EntityScan(basePackages = "com.wlh.study")
public class Study2Application {

    public static void main(String[] args) {
        SpringApplication.run(Study2Application.class, args);
    }

}
