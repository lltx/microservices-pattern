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
    @SneakyThrows
    @GetMapping("/createOrder")
    public String createOrder() {
        return "创建订单服务";
    }
}
