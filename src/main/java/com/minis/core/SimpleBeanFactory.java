package com.minis.core;

import com.minis.BeanDefinition;
import com.minis.BeansException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory, BeanDefinitionRegistry{
    private Map<String, BeanDefinition> beanDefinitions=  new ConcurrentHashMap<>(256);
    private List<String> beanDefintionNames = new ArrayList<>();

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object singleton = this.getSingleton(beanName);
        if( singleton == null){
            BeanDefinition beanDefinition = beanDefinitions.get(beanName);
            if(beanDefinition == null){
                throw new BeansException("No such BeanDefinition");
            }
            try{
                singleton = Class.forName(beanDefinition.getClassName()).newInstance();
            }catch (Exception e){
                throw  new BeansException(" No such BeanDefinition");
            }
            this.registerSingleton(beanName, singleton);

        }
        return singleton;

    }

    @Override
    public void registryBean(String beanName, Object obj) {
        this.registerSingleton(beanName, obj);
    }

    @Override
    public Boolean containsBean(String name) {
        return this.containsSingleton(name);
    }

    @Override
    public boolean isSingleton(String name) {
        return this.beanDefinitions.get(name).isSingleton();
    }

    @Override
    public boolean isPrototype(String name) {
        return this.beanDefinitions.get(name).isPrototype();
    }

    @Override
    public Class<?> getType(String name) {
        return  this.beanDefinitions.get(name).getClass();
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition){
        this.beanDefinitions.put(beanDefinition.getId(), beanDefinition);
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition bd) {
        this.beanDefinitions.put(name, bd);
        this.beanDefintionNames.add(name);
        if(!bd.isLazyInit()){
            try{
                getBean(name);
            }catch (BeansException e){

            }
        }
    }


    @Override
    public void removeBeanDefinition(String name) {
        this.beanDefinitions.remove(name);
        this.beanDefintionNames.remove(name);
        this.removeSingleton(name);
    }

    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return this.beanDefinitions.get(name);
    }

    @Override
    public boolean containsBeanDefinition(String name) {
        return this.beanDefinitions.containsKey(name);
    }
}
