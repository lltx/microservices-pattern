package com.example.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

/**
 * @author lengleng
 * @date 2020/12/5
 * <p>
 * 订单服务调用
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final RestTemplate restTemplate;


    /**
     * 创建订单
     * name: 指定接口超时配置名称
     * fallbackMethod: 超时后降级方法
     */
    public CompletableFuture<String> createOrder() {
        return CompletableFuture.supplyAsync(() -> restTemplate.getForEntity("http://localhost:8070/createOrder"
                , String.class).getBody());
    }

    public CompletableFuture<String> getError(Throwable error) {
        log.warn("创建订单失败了 {}", error.getMessage());
        return CompletableFuture.completedFuture("");
    }
}
