package com.proxy.reflect;

import java.io.StringReader;

/**
 * @author: cdf
 * @create: 2020-03-03 09:57
 **/
public class Person {

	private final static String sex="男";
	private String name;
	private int age;

	public Person(){ }

	private Person(String name,int age){
		this.name=name;
		this.age=age;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age=age;
	}

	private String isHandsome(String info){
		String result=null;
		switch (info){
			case "帅":
				result="是一个帅哥";
				break;
			case "美":
				result="是一个美女";
				break;
				default:
					result="很丑啊";
		}
		return result;
	}

	public void speak(String name,int age){
		System.out.println("我叫:"+name+"  今年："+age+"岁");
	}

	public void listea(){
		System.out.println("我听不到");
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
