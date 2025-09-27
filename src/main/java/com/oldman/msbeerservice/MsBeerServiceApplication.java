package com.oldman.msbeerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;

@SpringBootApplication(exclude = ArtemisAutoConfiguration.class)
public class MsBeerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBeerServiceApplication.class, args);
    }

}
