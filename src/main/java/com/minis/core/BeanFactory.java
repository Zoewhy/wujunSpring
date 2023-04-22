package com.minis.core;

import com.minis.BeanDefinition;
import com.minis.BeansException;

public interface BeanFactory {

    public Object getBean(String beanName) throws BeansException;
    public void registryBean(String beanName, Object obj);
    public Boolean containsBean(String name);

    public boolean isSingleton(String name);
    public boolean isPrototype(String name);
    Class<?> getType(String name);
}
