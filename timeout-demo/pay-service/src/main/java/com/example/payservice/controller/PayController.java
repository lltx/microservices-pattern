package com.example.payservice.controller;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lengleng
 * @date 2020/12/5
 *
 * 支付接口
 */
@RestController
public class PayController {
    @SneakyThrows
    @GetMapping("/pay")
    public String pay(){
        // 模拟调用支付渠道耗时 10s
        Thread.sleep(10000);
        return "支付成功";
    }
}
