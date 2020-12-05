package com.example.product.controller;

import com.example.product.service.OrderService;
import com.example.product.service.PayService;
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

    private final PayService payService;

    /**
     * 用户点击购买
     *
     * @return
     */
    @SneakyThrows
    @GetMapping("/buy")
    public String buy() {
        log.info("--> 开始调用 ");
        // 模拟调用 订单服务下单
        orderService.createOrder()
                // 模拟调用 支付服务支付
                .thenApply(orderNo -> payService.pay()).get()
                .get();
        log.info("--> 结束调用 ");
        return "success";
    }
}
