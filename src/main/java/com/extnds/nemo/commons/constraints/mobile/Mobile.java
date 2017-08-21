package com.extnds.nemo.commons.constraints.mobile;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = MobileValidator.class)
@Documented
public @interface Mobile {

	String message() default "must be a well-formed mobile no.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
