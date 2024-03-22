package com.picsart.java.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.picsart.java")
@EnableAspectJAutoProxy
public class Log4j2Config {
}
