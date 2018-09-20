package com.sc.service.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Description:
 * @Version: 1.0
 * @ProjectName: spring-cloud
 * @PackageName: com.sc.service
 * @ClassName: TestApi
 * @Author: caixiangwei
 * @Email: Imagination@wenfex.com
 * @Date: 2018/9/20 - 2018
 * @Copyright (c) 2018年3月7日, developer@wemfex.com All Rights Reserved.
 */
@RequestMapping("testApi")
@FeignClient(name = "business-service")
public interface TestApi {

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say();
}
