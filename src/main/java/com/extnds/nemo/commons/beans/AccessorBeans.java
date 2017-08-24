package com.extnds.nemo.commons.beans;

import com.extnds.nemo.features.resume.ResumeAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validator;

@Configuration
public class AccessorBeans {

    @Bean
    public ResumeAccessor resumeAccessor(MongoDatabase mongoDatabase,
                                         ObjectMapper objectMapper,
                                         Validator validator) {

        return new ResumeAccessor(mongoDatabase, objectMapper, validator);
    }
}
