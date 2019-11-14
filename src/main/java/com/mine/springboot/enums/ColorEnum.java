package com.mine.springboot.enums;

/**
 * @author ASUS
 */

public enum ColorEnum {
    /**
     * 红
     */
    RED(1, "红色"),
    /**
     * 绿
     */
    GREEN(2, "绿色"),
    /**
     * 蓝
     */
    BLUE(3, "蓝色");

    private int index;
    private String name;

    ColorEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }
}
