package com.minis.core;

import com.minis.BeanDefinition;
import com.minis.BeansException;

public interface BeanFactory {

    public Object getBean(String beanName) throws BeansException;
    public void registerBeanDefinition(BeanDefinition beanDefinition);
}
