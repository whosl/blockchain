package com.b328.blockchain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.b328.blockchain.mapper")
public class MessageboardApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MessageboardApplication.class, args);
    }

}
