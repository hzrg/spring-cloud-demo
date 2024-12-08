package org.zrhou.demo.user.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * Describe: RibbonConfig
 * CreateBy: towerhou
 * Date: 2024/12/8
 **/
@Configuration
@RibbonClient(name = "my-client",configuration = MyRibbonConfig.class)
public class RibbonClientConfig {
}
