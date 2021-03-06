package com.organization.payment.annotation;

import com.organization.payment.validator.CreditCardNumberValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Validates a CreditCardNumber.
 *
 * @author Pedro Henrique F. Dias
 */
@Constraint(validatedBy = {CreditCardNumberValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface CreditCardNumber {

  String message() default "invalid credit card number";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
