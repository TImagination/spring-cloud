package com.sc.controller;

import com.sc.service.api.TestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Version: 1.0
 * @ProjectName: spring-cloud
 * @PackageName: com.sc.adminservice.controller
 * @ClassName: TestController
 * @Author: caixiangwei
 * @Email: Imagination@wenfex.com
 * @Date: 2018/9/19 - 2018
 * @Copyright (c) 2018年3月7日, developer@wemfex.com All Rights Reserved.
 */
@Controller
@RequestMapping
public class TestController {
    @Resource
    private TestApi testApi;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Map<String,Object> map){ String say = testApi.say();
        map.put("say", say);
        return "/list";
    }
}
