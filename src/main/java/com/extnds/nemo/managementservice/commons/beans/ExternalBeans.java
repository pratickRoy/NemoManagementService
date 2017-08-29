package com.extnds.nemo.managementservice.commons.beans;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalBeans {

    @Bean
    public MongoDatabase mongoDatabase(@Value("${mongo.uri}")  String uri) {

        MongoClientURI mongoClientURI = new MongoClientURI(uri);
        return new MongoClient(mongoClientURI)
            .getDatabase(mongoClientURI.getDatabase());
    }
}
