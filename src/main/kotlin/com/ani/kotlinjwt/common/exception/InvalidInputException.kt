package com.ani.kotlinjwt.common.exception

import java.lang.RuntimeException

class InvalidInputException(
    val fieldName: String = "",
    message: String = "Invalid Input"
) : RuntimeException(message)