package com.mine.springboot.module.testuser.service.impl;

import com.mine.springboot.module.testuser.dao.UserDao;
import com.mine.springboot.module.testuser.service.IGetUserCountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description:
 *
 * @author longcheng.guo   <longcheng.guo@ucarinc.com>
 * @version v1.0
 * @date 2019/10/17
 */
@Service
public class GetUserCountImpl implements IGetUserCountService {

    @Resource
    UserDao userDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Integer getUserCount() {
        logger.info("hello log");
        return userDao.getUserCount();
    }
}
