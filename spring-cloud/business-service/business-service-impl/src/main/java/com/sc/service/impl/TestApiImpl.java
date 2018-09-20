package com.sc.service.impl;

import com.sc.service.api.TestApi;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Version: 1.0
 * @ProjectName: spring-cloud
 * @PackageName: com.sc.service.impl
 * @ClassName: TestApiImpl
 * @Author: caixiangwei
 * @Email: Imagination@wenfex.com
 * @Date: 2018/9/20 - 2018
 * @Copyright (c) 2018年3月7日, developer@wemfex.com All Rights Reserved.
 */
@RestController
public class TestApiImpl implements TestApi {
    @Override
    public String say() {
        return "Hello word aaaaaaaaa";
    }
}
