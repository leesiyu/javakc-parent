package com.javakc.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author leesiyu
 * @version 1.0
 * @Copyright © 北京汇才同飞教育科技公司
 */
@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.javakc"})
public class CmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }

}
