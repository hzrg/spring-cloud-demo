package org.zrhou.demo.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zrhou.demo.order.service.IOrder;

/**
 * Describe: OrderController
 * CreateBy: towerhou
 * Date: 2024/12/7
 **/

@RestController
@RequestMapping("order")
public class OrderController {
    
    @Autowired
    private IOrder order;
    
    @GetMapping("/queryUserOrder")
    public String queryOrder(String orderId){
        return order.getOrder(orderId);
    }
}
