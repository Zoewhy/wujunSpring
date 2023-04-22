package com.minis.core;

import com.minis.BeanDefinition;
import org.dom4j.Element;

public class XmlBeanDefinitionReader {
    BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }
    public void loadBeanDefinition(Resource resource){
        while(resource.hasNext()){
            Element element = (Element) resource.next();
            String beanID  = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanClassName, beanID);
            this.beanFactory.registerBeanDefinition(beanDefinition);

        }
    }

}
