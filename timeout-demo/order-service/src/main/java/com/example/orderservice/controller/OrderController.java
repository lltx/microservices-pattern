package com.example.orderservice.controller;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lengleng
 * @date 2020/12/5
 */
@RestController
public class OrderController {
    @SneakyThrows
    @GetMapping("/createOrder")
    public String createOrder(){
        // 模拟创建订单耗时
        Thread.sleep(10000);
        return "创建订单服务";
    }
}
