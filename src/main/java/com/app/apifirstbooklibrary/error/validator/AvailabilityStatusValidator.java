package com.app.apifirstbooklibrary.error.validator;

import com.app.apifirstbooklibrary.error.annotation.ValidAvailabilityStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class AvailabilityStatusValidator implements ConstraintValidator<ValidAvailabilityStatus, Enum<?>> {
    private Pattern pattern;
    private ValidAvailabilityStatus validAvailabilityStatus;

    @Override
    public void initialize(ValidAvailabilityStatus constraintAnnotation) {
        try {
            pattern = Pattern.compile(constraintAnnotation.regexp());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Given regex is invalid", e);
        }
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null)
            return false;

        Matcher m = pattern.matcher(value.name());

        if(m.matches())
            return true;
        else {
            context = context.buildConstraintViolationWithTemplate(validAvailabilityStatus.message())
                    .addConstraintViolation();
            context.disableDefaultConstraintViolation();

            return false;
        }
    }
}
