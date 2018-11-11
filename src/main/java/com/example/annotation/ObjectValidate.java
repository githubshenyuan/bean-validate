package com.example.annotation;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
public  @interface ObjectValidate {
    /**
     * 规则校验的唯一标识
     * */
    String id() default "";
    /**
     * 规则校验的父规则id 只有父规则校验通过时,才可以校验此规则
     */
    String superId() default "";
    /**
     * 是否允许为空
     * false 允许为空
     * true  不允许为空
     */
    boolean notNull() default false;

}
