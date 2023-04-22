package com.minis.core;

import com.minis.BeanDefinition;
import com.minis.BeansException;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXMLApplicationContext implements BeanFactory{
    BeanFactory beanFactory;
    //context负责整合容器的启动过程，读外部配置，解析Bean定义，创建BeanFactory
    public ClassPathXMLApplicationContext(String fileName){
        Resource resource = new ClassPathXMLResource(fileName);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinition(resource);
        this.beanFactory = beanFactory;
    }

    //context再对外提供一个getBean，底下就是调用的BeanFactory对应的方法
    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }


//    private List<BeanDefinition> beanDefinitions = new ArrayList<BeanDefinition>();
//    private Map<String, Object> singletons = new HashMap<String, Object>();
//    public ClassPathXMLApplicationContext(String fileName){
//        this.readXml(fileName);
//        this.instanceBeans();
//    }
//
//    //利用反射创建Bean实例，并存储在singletons中
//    private void instanceBeans()  {
//
//        for (BeanDefinition beanDefinition : beanDefinitions) {
//            try{
//                singletons.put(beanDefinition.getId(),Class.forName(beanDefinition.getClassName()).newInstance());
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void readXml(String fileName) {
//        SAXReader saxReader = new SAXReader();
//        try{
//            URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
//            saxReader.read(xmlPath);
//            Document document = saxReader.read(xmlPath);
//            Element rootElement = document.getRootElement();
//            //对配置文件中的每一个，进行处理
//            for (Element element : (List<Element>)rootElement.elements()) {
//                //获取Bean的基本信息
//                String beanID = element.attributeValue("id");
//                String className = element.attributeValue("class");
//                BeanDefinition beanDefinition = new BeanDefinition(className, beanID);
//                //将Bean的定义存放到beanDefinitions
//                beanDefinitions.add(beanDefinition);
//            }
//        }catch (Exception e){
//
//        }
//    }
//
//    public Object getBean(String beanName) { return singletons.get(beanName); }
}
