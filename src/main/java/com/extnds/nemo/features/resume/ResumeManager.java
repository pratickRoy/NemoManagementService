package com.extnds.nemo.features.resume;

import com.extnds.nemo.features.BaseManager;
import com.extnds.nemo.features.resume.model.BasicDetails;
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
