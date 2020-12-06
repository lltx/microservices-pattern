package com.example.orderservice.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lengleng
 * @date 2020/12/5
 */
@Slf4j
@RestController
public class OrderController {
    private static int num = 0;
    @SneakyThrows
    @GetMapping("/createOrder")
    public String createOrder() {
        log.info("开始请求创建订单接口 {}", ++num);
        // 请求次数奇数模拟创建订单异常
        if (num % 2 != 0) {
            throw new RuntimeException();
        }
        return "创建订单服务";
    }
}
