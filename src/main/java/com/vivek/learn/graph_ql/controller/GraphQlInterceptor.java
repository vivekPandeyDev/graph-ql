package com.vivek.learn.graph_ql.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class GraphQlInterceptor implements WebGraphQlInterceptor {
    @Override
    public Mono<WebGraphQlResponse> intercept(WebGraphQlRequest request, Chain chain) {
        log.info("interceptor log : {}",request.getOperationName());
        log.info("interceptor log : {}",request.getUri());
        log.info("interceptor log : {}",request.getExtensions());
        return chain.next(request);
    }
}
