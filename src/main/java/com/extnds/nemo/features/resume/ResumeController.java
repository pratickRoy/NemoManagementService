package com.extnds.nemo.features.resume;

import com.extnds.nemo.features.BaseController;
import com.extnds.nemo.features.resume.model.BasicDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ResumeController extends BaseController {

    private ResumeManager resumeManager;

    @Autowired
    public ResumeController(ResumeManager resumeManager) {
        this.resumeManager = resumeManager;
    }

    @RequestMapping("/basicDetails")
    public BasicDetails greeting(@RequestParam String id) {

        log.error("HELLO");
        return resumeManager.fetchBasicDetails(id).orElse(null);
    }
}
