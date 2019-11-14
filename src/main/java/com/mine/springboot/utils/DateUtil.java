package com.mine.springboot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:
 *
 * @author longcheng.guo   <longcheng.guo@ucarinc.com>
 * @version v1.0
 * @date 2019/11/14
 */

public class DateUtil {

    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";

    public static String timestampToDate(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || "null".equals(seconds)) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = YYYYMMDDHHMMSS;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date(Long.valueOf(seconds)));
    }

    public static String timestampToDate(String seconds) {
        return timestampToDate(seconds, YYYYMMDDHHMMSS);
    }
}
