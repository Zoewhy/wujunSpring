package com.minis.core;

import com.minis.BeanDefinition;
import com.minis.BeansException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimpleBeanFactory implements BeanFactory{

    private List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private HashMap<String, Object> singletons = new HashMap<>();
    private List<String> beanNames = new ArrayList<>();

    public SimpleBeanFactory(){}

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object singleton = singletons.get(beanName);
        if(singleton == null){
            int i =  beanNames.indexOf(beanName);
            if( i == -1){
                throw new BeansException("");
            }else{
                BeanDefinition beanDefinition = beanDefinitions.get(i);
                try{
                    singleton = Class.forName(beanDefinition.getClassName()).newInstance();
                }catch (Exception e){

                }
                singletons.put(beanDefinition.getId(), singleton);
            }

        }
        return singleton;
    }



    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        if(beanDefinition != null){
            this.beanDefinitions.add(beanDefinition);
            this.beanNames.add(beanDefinition.getId());
        }
    }
}
