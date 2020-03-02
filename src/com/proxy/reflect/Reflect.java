package com.proxy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * @author: cdf
 * @create: 2020-03-03 00:16
 **/
public class Reflect {

//    public static Logger logger = Logger.getLogger(Reflect.class);

    public static void main(String[] args) {
        Reflect.reflectPrivateFiled();
        reflectNewInstance();
        reflectPrivateConstructor();
        reflectPrivateFiled();
        reflectPrivateMethod();
        publicMethod();
    }

    //创建对象
    public static void reflectNewInstance() {
        try {
            Class<?> aClass = Class.forName("com.proxy.reflect.Book");
            Book b = (Book) aClass.newInstance();
            b.setName("陈登峰");
            b.setAuthor("付艳玲");
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射私有构造方法
    public static void reflectPrivateConstructor() {
        try {
            Class<?> aClass = Class.forName("com.proxy.reflect.Book");
            Constructor  declaredConstructor=aClass.getDeclaredConstructor(String.class,String.class,int.class);
            declaredConstructor.setAccessible(true);
            Book b=(Book)declaredConstructor.newInstance("陈登峰","陈登峰",18);
            System.out.println(b.toString());
            System.out.println(aClass.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射私有属性
    public static void reflectPrivateFiled(){
        try {
            Class<?> aClass = Class.forName("com.proxy.reflect.Book");
            Book b=(Book) aClass.newInstance();
            Field field=aClass.getDeclaredField("TAG");
            field.setAccessible(true);
            String tag=(String) field.get(b);
            System.out.println(tag);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射返回私有方法
    public static void reflectPrivateMethod(){
        try {
            Class<?> aClass = Class.forName("com.proxy.reflect.Book");
            Method m=aClass.getDeclaredMethod("chooseIndex",int.class);
            Book b= (Book) aClass.newInstance();
            m.setAccessible(true);
            String result=(String) m.invoke(b,2);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //返回public方法
    public static void publicMethod(){
        try {
            Class<?> aClass = Class.forName("com.proxy.reflect.Book");
            Book b=(Book) aClass.newInstance();
            Method m=aClass.getMethod("isMan", String.class);
            String result=(String) m.invoke(b,"xxx");
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
