package com.extnds.nemo.managementservice.features.resume;

import com.extnds.nemo.managementservice.commons.exceptions.InternalServerException;
import com.extnds.nemo.models.features.resume.BasicDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

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

    @Autowired
    public ResumeAccessor(MongoDatabase mongoDatabase,
                          ObjectMapper objectMapper) {

        this.database = mongoDatabase;
        this.objectMapper = objectMapper;
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

        basicDetails.validate();
        return Optional.of(basicDetails);
    }
}
