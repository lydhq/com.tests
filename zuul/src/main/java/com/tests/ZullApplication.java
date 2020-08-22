package com.tests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableAutoConfiguration
public class ZullApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZullApplication.class,args);
    }
}
