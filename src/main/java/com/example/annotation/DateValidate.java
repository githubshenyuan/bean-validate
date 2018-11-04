package com.example.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
public @interface DateValidate {
    String id() default "";
    String format() default "yyyy-MM-dd HH:mm:ss";

}
