package com.intro.springboot.form.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidator implements ConstraintValidator<IdentificadorRegex, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}"))
			return true;
		return false;
	}

}
