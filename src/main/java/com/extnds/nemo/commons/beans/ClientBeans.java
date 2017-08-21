package com.extnds.nemo.commons.beans;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientBeans {

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient();
    }
}
