package com.example;

import com.example.annotation.DateValidate;
import com.example.annotation.ObjectValidate;
import com.example.annotation.StringValidate;
import com.example.annotation.Validate;
import com.example.entity.ValidReturn;
import com.example.entity.RuleEntity;
import com.example.utils.PropertyUtil;
import com.example.utils.StringUtil;
import com.sun.deploy.util.StringUtils;

import java.beans.IntrospectionException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

public class BeanValidate {
    public static ValidReturn validate(Object object) throws IllegalAccessException, IntrospectionException {
        return validate(object, null);
    }

    public static ValidReturn validate(Object object, List<RuleEntity> ruleEntities) throws IllegalAccessException, IntrospectionException {
        ValidReturn validReturn = new ValidReturn("", "fail", "初始");
        // 获取对象类信息
        Class clazz = object.getClass();
        // 判断类上是否存在 验证 注解
        Annotation clazzAnnotation = clazz.getAnnotation(Validate.class);
        if (clazzAnnotation == null) {
            return null;
        }
        Map<String, Field> inheritFieldMap = new HashMap<String, Field>();
        // 获取对象的所有字段
        List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
        for (Field field : fields) {

            FieldValidate(field, object, inheritFieldMap);
        }

        return validReturn;
    }

    private static ValidReturn FieldValidate(Field field, Object object,Map<String, Field> inheritFieldMap) throws IllegalAccessException, IntrospectionException {
        ValidReturn validReturn = new ValidReturn("","","");
        Annotation[] annotations = field.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof StringValidate) {
                StringValidate stringValidate = (StringValidate) annotation;
                if (!stringValidate.superId().equals("")) {
                    inheritFieldMap.put(((StringValidate) annotation).superId(), field);
                } else {
                    validReturn = validateField(stringValidate, object, field);
                    if (validReturn.getCode().equals("200")) {
                        if ((inheritFieldMap.get(stringValidate.id())) != null) {
                            Field inheritField = inheritFieldMap.get(stringValidate.id());
                            validReturn = FieldValidate(inheritField, object, inheritFieldMap);
                        }
                    } else {
                        return validReturn;
                    }
                }
            } else if (annotation instanceof ObjectValidate) {
                ObjectValidate objectValidate = (ObjectValidate) annotation;
                Object object1 = PropertyUtil.getProperty(object, field.getName());
                return validate(object1);

            } else if (annotation instanceof DateValidate) {
                System.out.println("输出");
            }
        }

        return validReturn;
    }


    private static ValidReturn validateField(RuleEntity ruleEntity, Object object, Field field) throws IllegalAccessException, IntrospectionException {
        String value = (String) PropertyUtil.getProperty(object, field.getName());
        // 自定规则为空直接返回
        if (ruleEntity == null) {
            return null;
        }
        // 校验字符串最小值
        if (ruleEntity.getMinLength() != -1 && !StringUtil.compareMin(value, ruleEntity.getMinLength())) {
            return ValidReturn.fail(ruleEntity.getId(), ruleEntity.getCode(), ruleEntity.getMinLengthMsg());

        }
        // 校验字符串最大值
        if (ruleEntity.getMaxLength() != -1 && !StringUtil.compareMax(value, ruleEntity.getMaxLength())) {
            return ValidReturn.fail(ruleEntity.getId(), ruleEntity.getCode(), ruleEntity.getMaxLengthMsg());
        }
        return ValidReturn.success("", "200", "success");
    }

    private static ValidReturn validateField(StringValidate validate, Object object, Field field) throws IllegalAccessException, IntrospectionException {
        String value = (String) PropertyUtil.getProperty(object, field.getName());
        if (validate.minLength() != -1 && !StringUtil.compareMin(value, validate.minLength())) {
            return ValidReturn.fail(validate.id(), validate.code(), validate.minLengthMsg());
        }
        if (validate.maxLength() != -1 && !StringUtil.compareMax(value, validate.maxLength())) {
            return ValidReturn.fail(validate.id(), validate.code(), validate.minLengthMsg());
        }

        return ValidReturn.success("", "200", "success");
    }
}
