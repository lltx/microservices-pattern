package com.example.product.service;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

/**
 * @author lengleng
 * @date 2020/12/5
 * <p>
 * 支付服务调用
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PayService {

    private final RestTemplate restTemplate;

    /**
     * 支付
     */
    @TimeLimiter(name = "pay", fallbackMethod = "getError")
    public CompletableFuture<String> pay() {
        return CompletableFuture.supplyAsync(() -> restTemplate.getForEntity("http://localhost:8060/pay"
                , String.class).getBody());
    }

    public CompletableFuture<String> getError(Throwable error) {
        log.warn("支付订单失败 {} ", error.getMessage());
        return CompletableFuture.completedFuture("");
    }
}
