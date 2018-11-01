package com.bilin.container;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/applicationContext.xml"});
        context.start();

        synchronized (Provider.class) {  
            while (true) {  
                try {  
                	Provider.class.wait();  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }
}
          