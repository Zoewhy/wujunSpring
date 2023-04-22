package com.minis;

public class BeanDefinition {

    private String className;
    private String id;

    public BeanDefinition(String className, String id) {
        this.className = className;
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
