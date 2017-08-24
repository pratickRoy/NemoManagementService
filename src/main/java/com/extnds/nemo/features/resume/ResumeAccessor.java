package com.extnds.nemo.features.resume;

import com.extnds.nemo.commons.exceptions.InternalServerException;
import com.extnds.nemo.commons.exceptions.ValidationException;
import com.extnds.nemo.features.resume.model.BasicDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static com.mongodb.client.model.Filters.eq;

public class ResumeAccessor {

    @AllArgsConstructor
    @Getter
    private enum ResumeKeys {

        BASIC_DETAILS("basicDetails"),
        _ID("_id");

        private String key;
    }

    private MongoDatabase database;
    private ObjectMapper objectMapper;
    private Validator validator;

    @Autowired
    public ResumeAccessor(MongoDatabase mongoDatabase,
                          ObjectMapper objectMapper,
                          Validator validator) {

        this.database = mongoDatabase;
        this.objectMapper = objectMapper;
        this.validator = validator;
    }

    Optional<BasicDetails> fetchBasicDetails(String id) {

        MongoCollection<Document> collection = database.getCollection(ResumeKeys
            .BASIC_DETAILS
            .getKey());

        Document basicDetailsDocument = collection
            .find(eq(ResumeKeys._ID.getKey(), new ObjectId(id)))
            .first();

        if(Objects.isNull(basicDetailsDocument)) {
            return Optional.empty();
        }

        BasicDetails basicDetails;
        try {
            basicDetails = objectMapper.readValue(basicDetailsDocument.toJson(),
                BasicDetails.class);
        } catch (IOException e) {

            throw new InternalServerException(e);
        }

        Set<ConstraintViolation<BasicDetails>> violations = validator.validate(basicDetails);
        if(!violations.isEmpty()) {
            throw new ValidationException(violations);
        }
        return Optional.of(basicDetails);
    }
}
