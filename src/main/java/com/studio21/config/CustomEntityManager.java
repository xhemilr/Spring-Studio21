package com.studio21.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CustomEntityManager {

    private static final String url = "spring.datasource.url";

    @Autowired
    private static Environment env;

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(getProperty(url));

    public static String getProperty(String key){
        return env.getProperty(key);
    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
