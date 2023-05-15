package com.pragmantic.managerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ManagerapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerapiApplication.class, args);
    }
}
