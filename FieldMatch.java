package com.foodhotelics.demo.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({TYPE,ANNOTATION_TYPE})
@Constraint(validatedBy = FieldMatchValidator.class)
public @interface FieldMatch {
 String message() default "";
 Class<?>[] groups() default {};
 Class<? extends Payload>[] payload() default {};
 String first();
 String second();
 
 @Target({TYPE,ANNOTATION_TYPE})
 @Retention(RUNTIME)
 @Documented
 @interface List{
	 FieldMatch[] value();
  }
 }
