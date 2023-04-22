package com.minis.test;

public class AServiceImpl implements IAService{
    public void sayHello() {
        System.out.println("a service 1 say hello");
    }
    private String property1;
    public void setProperty1(String property1){
        this.property1 = property1;
    }
    private String name;
    private int level;
    public AServiceImpl(String name, int level){
        this.name = name;
        this.level = level;
    }
}
