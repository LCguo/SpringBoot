package com.mine.springboot.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author longcheng.guo
 */
class DateUtilTest {

    @Test
    void timestampToDate() {
        String date = String.valueOf(System.currentTimeMillis());
        System.out.println(DateUtil.timestampToDate(date));
    }
}