package com.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description:
 * @Version: 1.0
 * @ProjectName: ssss
 * @PackageName: com.sc.service
 * @ClassName: BussinesServiceAppliaction
 * @Author: caixiangwei
 * @Email: Imagination@wenfex.com
 * @Date: 2018/9/19 - 2018
 * @Copyright (c) 2018年3月7日, developer@wemfex.com All Rights Reserved.
 */
@SpringBootApplication
@EnableEurekaServer
@ComponentScan(basePackages = { "com.sc"})
public class BusineseServiceAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(BusineseServiceAppliaction.class,args);
    }
}
