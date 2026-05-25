package com.aryak.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ElasticAgentExploreApplication {

    static void main(String[] args) {
        SpringApplication.run(ElasticAgentExploreApplication.class, args);
    }

}
