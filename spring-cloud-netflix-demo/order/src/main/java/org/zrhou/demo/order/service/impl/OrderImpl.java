package org.zrhou.demo.order.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zrhou.demo.order.service.IOrder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Describe: OrderImpl
 * CreateBy: towerhou
 * Date: 2024/12/7
 **/
@Service
public class OrderImpl implements IOrder {
    @Value("${server.port}")
    private String port;

    @Override
    public String getOrder(String userId) {
        System.out.println("port：" + this.port);
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowStr = sdf.format(now);
        return "用户：" + userId + "在：" + nowStr + "前下过单";
    }
}
