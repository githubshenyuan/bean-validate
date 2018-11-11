package com.example.utils;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 字符串处理的工具类
 * @author sh_home on 2018/11/10 16:27
 * @version ideaIU-2018.2.3.win
 */
public class StringUtil {
    /**
     * 检查字符串长度是否大于等于设定值
     * @return
     */
    public  static boolean compareMin(String value,int min) {
        return !(value == null || value.length() < min);
    }

    /**
     * 检查字符串长度是否小于等于设定值
     * @param value
     * @param max
     * @return
     */
    public static boolean compareMax(String value, int max) {
        return !(value == null || value.length() > max);
    }
}
