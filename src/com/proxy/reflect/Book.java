package com.proxy.reflect;

/**
 * @author: cdf
 * @create: 2020-03-03 00:08
 **/
public class Book {

    private final static String TAG="Bookshop";

    private String name;
    private String author;
    private int age;

    public Book(){}

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    private Book(String name,String author,int age){
        this.name=name;
        this.author=author;
        this.age=age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }

    public String isMan(String sex){
        String result=null;
        switch (sex){
            case "男":
                result="我是男的";
                break;
            case "女":
                result="我是女的";
                break;
                default:
                    result="我是人妖";
        }
        return result;
    }

    private String chooseIndex(int index){
         String string=null;
         switch (index){
             case 1:
                 string="我叫1号";
                 break;
             case 2:
                 string="我叫2号";
                 break;
             default:
                 string="我是默认的";
         }
         return string;
    }
}
