package com.aryak.elastic.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic demoTopic() {
        return new NewTopic("demo-topic", 1, (short) 1);
    }
}
