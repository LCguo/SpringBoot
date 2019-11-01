package com.mine.springboot.module.test.controller;

import com.mine.springboot.module.test.service.ITestService;
import com.mine.springboot.module.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author longcheng.guo   <longcheng.guo@ucarinc.com>
 * @version v1.0
 * @date 2019/10/18
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    ITestService testService;

    @GetMapping("/testRedis")
    public String testRedis() {
        return testService.testRedis();
    }
}
