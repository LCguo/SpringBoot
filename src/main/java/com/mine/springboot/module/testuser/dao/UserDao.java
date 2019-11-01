package com.mine.springboot.module.testuser.dao;

import org.springframework.stereotype.Repository;

/**
 * description:
 *
 * @author longcheng.guo   <longcheng.guo@ucarinc.com>
 * @version v1.0
 * @date 2019/10/17
 */
@Repository
public interface UserDao {

    Integer getUserCount();
}
