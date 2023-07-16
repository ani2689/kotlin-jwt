package com.ani.kotlinjwt.common.annotation

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class VaildEnumVaildator : ConstraintValidator<VaildEnum, Any> {
    private lateinit var enumValues: Array<out Enum<*>>

    override fun initialize(annotation: VaildEnum) {
        enumValues = annotation.enumClass.java.enumConstants
    }

    override fun isValid(value: Any?, context: ConstraintValidatorContext?): Boolean {
        if(value == null)
            return true
        return enumValues.any { it.name == value.toString() }
    }
}