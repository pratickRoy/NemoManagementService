package com.extnds.nemo.commons.constraints.mobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class MobileValidator implements ConstraintValidator<Mobile, String> {

	private static Pattern VALID_MOBILE_PATTERN = Pattern.compile("^(\\+?\\d{1,4}[\\s-])?(?!0+\\s+,?$)\\d{10}\\s*,?$");

	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {

		return object == null || VALID_MOBILE_PATTERN.matcher(object).matches();
	}

}
