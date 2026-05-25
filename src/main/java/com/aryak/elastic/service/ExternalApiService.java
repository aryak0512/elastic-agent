package com.aryak.elastic.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExternalApiService {

    private final RestClient restClient;

    public String callExternalApi() {

        log.info("Calling external REST API");

        String response = restClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve()
                .body(String.class);

        log.info("Received response from external API");

        return response;
    }
}
