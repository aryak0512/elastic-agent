package com.aryak.elastic.kafka;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {

        log.info("Sending kafka message: {}", message);
        kafkaTemplate.send("demo-topic", message);
    }
}
