package com.example.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
public @interface StringValidate {
    /**
     * 规则校验的唯一标识
     * */
    String id() default "";
    /**
     * 规则校验的父规则id 只有父规则校验通过时,才可以校验此规则
     */
    String superId() default "";
    /**
     * 校验字符串最小长度
     */
    int minLength() default -1;
    /**
     * 长度校验不通过是返回信息
     * */
    String minLengthMsg() default "";
    /**
     * 校验字段串最大长度
     */
    int maxLength() default -1;
    /**
     * 长度校验不通过是返回信息
     * */
    String maxLengthMsg() default "";
    /**
     * 校验字符串格式,多用于日期的格式校验
     */
    String dateFormat() default "";
    /**
     * 校验不通过是返回信息
     */
    String dateFormatMsg() default "";

    /**
     * 校验不通过时返回的代码
     */
    String code() default "";
    /**
     * 校验不通过是返回信息
     */
    String msg()default "";



}
