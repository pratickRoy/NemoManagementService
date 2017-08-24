package com.extnds.nemo.commons.beans;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalBeans {

    @Value("${mongo.username}") private String USERNAME;
    @Value("${mongo.prefix}")   private String MONGO_PREFIX;
    @Value("${mongo.url}")      private String URL;
    @Value("${mongo.port}")     private String PORT;
    @Value("${mongo.password}") private String PASSWORD;
    @Value("${mongo.database}") private String DATABASE;

    @Bean
    public MongoDatabase mongoDatabase() {

        return new MongoClient(new MongoClientURI(new StringBuilder(MONGO_PREFIX)
            .append(USERNAME).append(':')
            .append(PASSWORD).append('@')
            .append(URL).append(':')
            .append(PORT).append('/')
            .append(DATABASE).toString()))
            .getDatabase(DATABASE);
    }
}
