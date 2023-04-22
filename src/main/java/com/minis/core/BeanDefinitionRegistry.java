package com.minis.core;

import com.minis.BeanDefinition;

public interface BeanDefinitionRegistry {

    public void registerBeanDefinition(String name, BeanDefinition bd);
    public void removeBeanDefinition(String name);
    public BeanDefinition getBeanDefinition(String name);
    public boolean containsBeanDefinition(String name);
}
