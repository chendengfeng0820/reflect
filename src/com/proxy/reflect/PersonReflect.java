package com.proxy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: cdf
 * @create: 2020-03-03 10:11
 * @info 反射练习
 **/
public class PersonReflect {


	public static void main(String[] args) {
		PersonReflect.reflectInstance();
		PersonReflect.reflectPrivateFiled();
		reflectPrivateConstructor();
		reflextPrivateMethod();
		reflectPublicMethod();
		reflectPublic();
	}

	//创建对象
	public static void reflectInstance(){
		try {
			Class<?> aClass = Class.forName("com.proxy.reflect.Person");
			Person p=(Person) aClass.newInstance();
			p.setAge(18);
			p.setName("陈登峰");
			System.out.println(p.toString());
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//反射私有属性
	public static void reflectPrivateFiled(){
		try {
			Class<?> aClass = Class.forName("com.proxy.reflect.Person");
			Field field=aClass.getDeclaredField("sex");
			Person p=(Person) aClass.newInstance();
			field.setAccessible(true);
			String sex=(String) field.get(p);
			System.out.println(sex);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//反射私有构造方法
	public static void reflectPrivateConstructor(){
		try {
			Class<?> aClass = Class.forName("com.proxy.reflect.Person");
			Constructor<?> constructor = aClass.getDeclaredConstructor(String.class, int.class);
			constructor.setAccessible(true);
			Person p=(Person) constructor.newInstance("陈登峰",18);
			System.out.println(p.toString());
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//反射私有方法
	public static void reflextPrivateMethod(){
		try {
			Class<?> aClass = Class.forName("com.proxy.reflect.Person");
			Method isHandsome = aClass.getDeclaredMethod("isHandsome", String.class);
			isHandsome.setAccessible(true);
			Person person=(Person) aClass.newInstance();
			String result=(String) isHandsome.invoke(person,"美");
			System.out.println(result);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//反射公有方法
	public static void reflectPublicMethod(){
		try {
			Class<?> aClass = Class.forName("com.proxy.reflect.Person");
			Method method=aClass.getMethod("speak", String.class, int.class);
			Person p=(Person) aClass.newInstance();
			method.invoke(p,"cdf",20);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//反射无参public方法
	public static void reflectPublic(){
		try {
			Class<?> aClass = Class.forName("com.proxy.reflect.Person");
			Method method=aClass.getMethod("listea");
			Person person =(Person) aClass.newInstance();
			method.invoke(person);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

