package com.extnds.nemo.managementservice.features.resume;

import com.extnds.nemo.managementservice.features.BaseManager;

import com.extnds.nemo.models.features.resume.BasicDetails;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ResumeManager extends BaseManager {

    private ResumeAccessor resumeAccessor;

    @Autowired
    public ResumeManager(ResumeAccessor resumeAccessor) {
        this.resumeAccessor = resumeAccessor;
    }

    Optional<BasicDetails> fetchBasicDetails(String id) {

        return resumeAccessor.fetchBasicDetails(id);
    }
}
