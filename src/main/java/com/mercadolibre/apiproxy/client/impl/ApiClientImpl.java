package com.mercadolibre.apiproxy.client.impl;

import com.mercadolibre.apiproxy.client.ApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
@Slf4j
public class ApiClientImpl implements ApiClient {


    @Override
    public Mono<Object> getApiML(String path) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            log.info("[getApiML][path: {}]", path);
            URI uri = UriComponentsBuilder.fromUriString("https://api.mercadolibre.com/" + path)
                    .build()
                    .toUri();
            Object res = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<Object>() {
            }).getBody();
            log.info("[get][FIN OK]");
            return Mono.justOrEmpty(res);
        } catch (Exception e) {
            log.error("[get][FIN EX]", e);
            throw e;
        }
    }
}
