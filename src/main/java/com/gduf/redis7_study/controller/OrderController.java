package com.gduf.redis7_study.controller;

import com.gduf.redis7_study.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LuoXuanwei
 * @date 2023/8/11 0:40
 */
@RestController
@Slf4j
@Api(tags = "订单接口")
public class OrderController {
    @Resource
    private OrderService orderService;

    @ApiOperation("新增订单")
    @PostMapping("/order/add")
    public void addOrder() {
        orderService.addOrder();
    }

    @ApiOperation("按照keyId查询订单")
    @GetMapping("/order/{keyId}")
    public String getOrderById(@PathVariable Integer keyId) {
        return orderService.getOrderById(keyId);
    }
}
