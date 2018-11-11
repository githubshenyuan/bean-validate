package com.example.annotation;

import java.lang.annotation.*;

/**
 * @author sh_home on 2018/11/11 21:33
 * @version ideaIU-2018.2.3.win
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
public @interface Validate {
}
