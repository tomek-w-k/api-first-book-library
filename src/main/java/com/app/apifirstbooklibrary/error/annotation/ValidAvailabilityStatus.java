package com.app.apifirstbooklibrary.error.annotation;

import com.app.apifirstbooklibrary.error.validator.AvailabilityStatusValidator;
import com.app.apifirstbooklibrary.error.validator.CapitalizedValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = AvailabilityStatusValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAvailabilityStatus {
    String regexp();
    String message() default "Availability status should have a value of an AvailabilityStatus enum.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String[] values() default {};
}
