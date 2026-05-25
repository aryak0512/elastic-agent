package com.aryak.elastic;


import com.aryak.elastic.kafka.DemoKafkaProducer;
import com.aryak.elastic.service.DbService;
import com.aryak.elastic.service.ExternalApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppScheduler {

    private final DemoKafkaProducer producer;

    private final ExternalApiService externalApiService;

    private final DbService dbService;

    @Scheduled(fixedRate = 5000)
    public void publish() {

        String message = "hello-kafka-" + LocalDateTime.now();

        producer.send(message);
        log.info("Sent message to kafka");

        String response = externalApiService.callExternalApi();

        log.info("External API response length={}", response.length());

        dbService.executeDbCalls();
    }
}
