package com.mine.springboot.module.testuser.controller;

import com.mine.springboot.module.testuser.service.IGetUserCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 *
 * @author longcheng.guo   <longcheng.guo@ucarinc.com>
 * @version v1.0
 * @date 2019/10/17
 */

@RestController
@RequestMapping("/test")
public class TestUserController {

    @Autowired
    IGetUserCountService userCountService;

    @GetMapping("/getUserCount")
    public Integer getUserCount() {
        return userCountService.getUserCount();
    }
}
