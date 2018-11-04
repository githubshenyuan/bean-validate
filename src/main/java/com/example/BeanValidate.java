package com.example;

import com.example.annotation.DateValidate;
import com.example.annotation.ObjectValidate;
import com.example.annotation.StringValidate;
import com.example.entity.ValidReturn;
import com.example.entity.RuleEntity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class BeanValidate {

    public static ValidReturn validate(Object object, List<RuleEntity> ruleEntities) {
        ValidReturn validReturn = new ValidReturn();
        // 获取对象的所有字段
        List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof StringValidate) {

                } else if (annotation instanceof ObjectValidate) {

                } else if (annotation instanceof DateValidate) {

                }
            }

        }

        return validReturn;


    }
}
