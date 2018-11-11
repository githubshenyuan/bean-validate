package com.example.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 类字段工具类
 * @author sh_home on 2018/11/11 20:32
 * @version ideaIU-2018.2.3.win
 */
public class PropertyUtil {
    @Deprecated
    public static PropertyDescriptor getPropertyDescriptor(Class clazz, String propertyName) {
        StringBuffer sb = new StringBuffer();//构建一个可变字符串用来构建方法名称
        Method setMethod = null;
        Method getMethod = null;
        PropertyDescriptor pd = null;
        try {
            Field f = clazz.getDeclaredField(propertyName);//根据字段名来获取字段
            if (f!= null) {
                //拼装方法的后缀
                String methodEnd = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                //拼装set方法
                sb.append("set" + methodEnd);
                // 获取字段set方法
                setMethod = clazz.getDeclaredMethod(sb.toString(), new Class[]{ f.getType() });
                //清空整个可变字符串
                sb.delete(0, sb.length());
                //拼装get方法
                sb.append("get" + methodEnd);
                //构建get 方法
                getMethod = clazz.getDeclaredMethod(sb.toString(), new Class[]{ });
                //构建一个属性描述器 把对应属性 propertyName 的 get 和 set 方法保存到属性描述器中
                pd = new PropertyDescriptor(propertyName, getMethod, setMethod);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return pd;
    }

    /**
     * 设置属性的值
     * @param obj
     * @param propertyName
     * @param value
     * @return
     * @throws IntrospectionException
     */
    public static boolean setProperty(Object obj,String propertyName,Object value) throws IntrospectionException {
        //获取对象类信息
        Class clazz = obj.getClass();
        //获取 clazz 类型中的 propertyName 的属性描述器
        PropertyDescriptor pd = new PropertyDescriptor(propertyName,clazz);
        //从属性描述器中获取 set 方法
        Method setMethod = pd.getWriteMethod();
        try {
            //调用 set 方法将传入的value值保存属性中去
            setMethod.invoke(obj, value);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //根据属性字段及对象获取对应的属性值

    /**
     * 获取属性值
     * @param obj
     * @param propertyName
     * @return
     * @throws IntrospectionException
     */
    public static Object getProperty(Object obj, String propertyName) throws IntrospectionException {
        //获取对象类信息
        Class clazz = obj.getClass();
        //获取 clazz 类型中的 propertyName 的属性描述器
        PropertyDescriptor pd = new PropertyDescriptor(propertyName,clazz);
        // 获取属性 的 get 方法
        Method getMethod = pd.getReadMethod();
        Object value =null ;
        try {
            //调用方法获取方法的返回值
            value = getMethod.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回值
        return value;
    }
}
