package com.studio21.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RestController
public class ConfigController {

    private static Properties properties = new Properties();

    private static final String DATASOURCE = "spring.datasource.url";
    private static final String USERNAME = "spring.datasource.username";
    private static final String PASSWORD = "spring.datasource.password";

    @Autowired
    private Environment env;

    @GetMapping("/config")
    public String getProperties() {
        String json = "";
        FileReader reader;
        try {
            reader = new FileReader("application.properties");
            properties.load(reader);
        } catch (IOException e) {
            json = e.getMessage();
        }
//        Map<String, String> properties = new HashMap<>();
//        properties.put(DATASOURCE, env.getProperty(DATASOURCE));
//        properties.put(USERNAME, env.getProperty(USERNAME));
//        properties.put(PASSWORD, env.getProperty(PASSWORD));

        try {
            json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(properties);
        }catch (JsonProcessingException e){
            json = e.getMessage();
        }
        return json;
    }

    @PutMapping("/config")
    public String setProperty(@RequestBody HashMap<String, String> property){
        if (property!=null){
            for (Map.Entry<String, String> entry:property.entrySet()){
                properties.setProperty(entry.getKey(), entry.getValue());
            }
        }
        try {
            FileOutputStream out = new FileOutputStream("application.properties");
            properties.store(out, null);
            out.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        } finally {

        }
        return "Values updated successfully";
    }
}
