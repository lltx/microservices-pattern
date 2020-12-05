package com.example.product.controller;

import com.example.product.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lengleng
 * @date 2020/12/5
 * <p>
 * 商品库存服务接口
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final OrderService orderService;

    /**
     * 用户点击购买
     */
    @SneakyThrows
    @GetMapping("/order")
    public String buy() {
        // 模拟调用 订单服务下单
        orderService.createOrder().get();
        return "success";
    }

    /***
     * 获取全部商品接口
     */
    @SneakyThrows
    @GetMapping("/products")
    public String products() {
        // 模拟查询DB 耗时
        Thread.sleep(100);
        return "products";
    }
}
