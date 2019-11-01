package com.mine.springboot.module.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * description:
 *
 * @author longcheng.guo   <longcheng.guo@ucarinc.com>
 * @version v1.0
 * @date 2019/10/18
 */

public class RedisUtils {

/*    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;*/

    @Autowired
    private  static RedisTemplate redisTemplate;

    RedisUtils() {

    }

    public static Boolean setRedis(String key, Object value) {
//        redisTemplate = new RedisTemplate();
        redisTemplate.opsForValue().set(key, value);
        return true;
    }
    public static Object getRedis(String key) {
//        redisTemplate = new RedisTemplate();
        return redisTemplate.opsForValue().get(key);
    }
}
