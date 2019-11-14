package com.mine.springboot.module.test.service.impl;

import com.mine.springboot.module.test.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author longcheng.guo   <longcheng.guo@ucarinc.com>
 * @version v1.0
 * @date 2019/10/18
 */
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String testRedis() {
       return null;
    }

    @Override
    public String testReturnString() {
        return "hello";
    }
}
