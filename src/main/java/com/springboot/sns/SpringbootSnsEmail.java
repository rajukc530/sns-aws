package com.springboot.sns;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringbootSnsEmail {

    // Main program to start up the spring boot application.
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSnsEmail.class, args);
        log.info("Spring-boot sns application started successfully.");
    }
}
