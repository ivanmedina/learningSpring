package com.intro.springboot.form.app.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = RequiredValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Required {

	String message() default "Campo es requerido - con anotaciones";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
