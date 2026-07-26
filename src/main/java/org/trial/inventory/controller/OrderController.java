package org.trial.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.trial.inventory.entity.Order;
import org.trial.inventory.service.OrderManagementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order/")
public class OrderController {

    private final OrderManagementService orderManagementService;

    @PostMapping("placeOrder")
    public Order placeOrder(@RequestBody List<String> orderList) {
        return orderManagementService.placeOrder(orderList);
    }
}
