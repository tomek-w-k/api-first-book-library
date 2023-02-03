package com.app.apifirstbooklibrary.error.validator;

import com.app.apifirstbooklibrary.error.annotation.Capitalized;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;


public class CapitalizedValidator implements ConstraintValidator<Capitalized, String> {

    private Capitalized uppercaseAnnotation;


    @Override
    public void initialize(Capitalized constraintAnnotation) {
        this.uppercaseAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String titleField, ConstraintValidatorContext context) {
        String correctName = buildCorrectName(titleField);
        if (uppercaseAnnotation.required()
                && (Objects.isNull(titleField)  || titleField.isBlank()
                || !correctName.equals(titleField))) {
            context = context
                    .buildConstraintViolationWithTemplate(this.uppercaseAnnotation.message())
                    .addConstraintViolation();
            context.disableDefaultConstraintViolation();
            return false;
        }
        return true;
    }

    private String buildCorrectName(String nameField) {
        String upCase = String.valueOf(nameField.charAt(0)).toUpperCase();
        String lowCase = nameField.substring(1).toLowerCase();
        return upCase.concat(lowCase);
    }
}
