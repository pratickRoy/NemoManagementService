package com.extnds.nemo.commons.exceptions;

import com.extnds.nemo.features.BaseModel;
import lombok.Getter;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ValidationException extends RuntimeException {

    private static final String VALIDATION_MAIN_EXCEPTION_MESSAGE_TEMPLATE = "Exception was thrown when trying to validate [%s]";
    private static final String VALIDATION_EXCEPTION_MESSAGES_TEMPLATE = "Property [%s] has value [%s] but it must conform to [%s]";

    private List<String> validationErrors;
    public ValidationException(Set<? extends ConstraintViolation<? extends BaseModel>> violationSet) {

        super(String.format(VALIDATION_MAIN_EXCEPTION_MESSAGE_TEMPLATE,
            violationSet.iterator().next().getRootBeanClass().getCanonicalName()));

        validationErrors = violationSet.stream()
            .map(constraintViolation -> String.format(
                VALIDATION_EXCEPTION_MESSAGES_TEMPLATE,
                constraintViolation.getPropertyPath(),
                constraintViolation.getInvalidValue(),
                constraintViolation.getMessage()))
            .collect(Collectors.toList());
    }
}
