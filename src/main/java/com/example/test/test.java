package com.example.test;

import com.example.BeanValidate;
import com.example.annotation.DateValidate;
import com.example.annotation.StringValidate;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class test {
    public static void main(String[] args) throws IllegalAccessException, IntrospectionException {
        User user = new User();
        user.setUuid("123");
        user.setUserName("username");
        user.setPassword("password");
        user.setInputDate("2018-11-02 12:01:32");

        Map<String, String> map = new HashMap<String, String>();


        System.out.println("呵呵呵");
        // System.out.println(BeanValidate.validate(user));


    }
}
