package com.minis.core;

public interface SingletonBeanRegistry {

    public void registerSingleton(String beanName, Object singletonObject);
    Object getSingleton(String beanName);

    boolean containsSingleton(String beanName);

    String[] getSingletonNames();

}
