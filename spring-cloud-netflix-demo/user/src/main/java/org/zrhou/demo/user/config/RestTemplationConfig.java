package org.zrhou.demo.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Describe: RestTemplationConfig
 * CreateBy: towerhou
 * Date: 2024/12/7
 **/
@Configuration
public class RestTemplationConfig {
    
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
