package org.zrhou.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.*;

/**
 * Describe: UserController
 * CreateBy: towerhou
 * Date: 2024/12/7
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    private List<String> urls = Arrays.asList("localhost:8881", "localhost:8882", "localhost:8883");

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/queryUserOrder")
    public String queryUserOrder(String userId) {
        Map<String, String> param = new HashMap<>();
        param.put("orderId", userId);
        Random random = new Random();
        int idx = random.nextInt(3);
        String result = restTemplate.getForObject("http://" + urls.get(idx) + "/order/queryUserOrder?orderId={orderId}", String.class, param);
        return result;
    }

    @GetMapping("ribbonQueryUserOrder")
    public String useRibbonQueryUserOrder(String userId) {
        ServiceInstance instance = loadBalancer.choose("my-client");
        URI myClientUri = URI.create(String.format("http://%s:%d/order/queryUserOrder?orderId=%s", instance.getHost(),
                instance.getPort(), userId));

        String result = restTemplate.getForObject(myClientUri.toString(), String.class);
        return result;
    }

}
