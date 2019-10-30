package com.ics.demospring.web;

import com.ics.demospring.rmi.LearningService;
import com.ics.demospring.rmi.LearningServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

import java.rmi.RMISecurityManager;

@Configuration
public class MyConfig {
    @Bean
    public SimpleJaxWsServiceExporter getJWS(){
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://0.0.0.0:8585/soap");
        return exporter;
    }

//    @Bean LearningService learningService() {
//        return new LearningServiceImpl();
//    }

    @Bean
    @Autowired
    public RmiServiceExporter getRmiExporter(LearningService learningService){

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        Class<LearningService> learningInterface = LearningService.class;
        ClassLoader classLoader = learningService.getClass().getClassLoader();
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(learningInterface);
        exporter.setRegistryPort(1099);
        exporter.setServiceName("LEARNING");
        exporter.setService(new LearningServiceImpl());
        exporter.setAlwaysCreateRegistry(true);
        exporter.setBeanClassLoader(classLoader);
//        exporter.setRegistry(getRmiExporter());
        return exporter;
    }
}
