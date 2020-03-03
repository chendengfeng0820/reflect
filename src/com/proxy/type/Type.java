package com.proxy.type;

/**
 * @author: cdf
 * @create: 2020-03-03 23:12
 **/
public class Type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer integer1;
		Integer integer2;

		integer1 = new Integer(10);
		integer2 = new Integer(10);
		//第一次比较
		System.out.println("第一次比较:"+(integer1==integer2));

		//第二次比较
		System.out.println("第二次比较:"+(integer1==10));

		integer1 = 127;
		integer2 = 127;
		//第三次比较
		System.out.println("第三次比较:"+(integer1==integer2));

		integer1 = 128;
		integer2 = 128;
		//第四次比较
		System.out.println("第四次比较:"+(integer1==integer2));

	}
}
