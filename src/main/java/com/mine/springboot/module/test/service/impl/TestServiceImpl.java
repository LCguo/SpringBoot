package com.mine.springboot.module.test.service.impl;

import com.mine.springboot.module.test.service.ITestService;
import com.mine.springboot.module.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.collections.RedisCollectionFactoryBean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
        RedisUtils.setRedis("test", "123");
        String s = new StringBuilder("abc")+ "123";
        Map m = new HashMap();
        return (String)RedisUtils.getRedis("test");
    }

    @Override
    public String testReturnString() {
        return "hello";
    }
}
