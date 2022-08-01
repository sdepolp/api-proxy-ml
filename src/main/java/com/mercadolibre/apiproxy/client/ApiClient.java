package com.mercadolibre.apiproxy.client;

import reactor.core.publisher.Mono;

public interface ApiClient {
    Mono<Object> getApiML(String path);
}
