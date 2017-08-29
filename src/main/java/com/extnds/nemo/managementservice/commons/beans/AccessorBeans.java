package com.extnds.nemo.managementservice.commons.beans;

import com.extnds.nemo.managementservice.features.resume.ResumeAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccessorBeans {

    @Bean
    public ResumeAccessor resumeAccessor(MongoDatabase mongoDatabase,
                                         ObjectMapper objectMapper) {

        return new ResumeAccessor(mongoDatabase, objectMapper);
    }
}
