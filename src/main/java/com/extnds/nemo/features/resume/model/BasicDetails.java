package com.extnds.nemo.features.resume.model;

import com.extnds.nemo.commons.constraints.mobile.Mobile;
import com.extnds.nemo.features.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@Getter
public class BasicDetails extends BaseModel {

    @AllArgsConstructor
    @Getter
    private static class ExternalLinks {

        @NotNull
        private final String linkName;

        @NotNull
        @URL
        private final String linkUrl;
    }

    @NotNull
    private final String firstName;

    @NotNull
    private final String lastName;

    @NotNull
    private final String workProfile;

    @NotNull
    @Mobile
    private final String mobile;

    @NotNull
    @Email
    private final String emailAddress;

    @Valid
    private final List<ExternalLinks> links;
}
