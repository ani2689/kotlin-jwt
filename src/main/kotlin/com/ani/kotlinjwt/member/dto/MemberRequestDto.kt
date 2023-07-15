package com.ani.kotlinjwt.member.dto

import com.ani.kotlinjwt.common.status.Gender
import java.time.LocalDate

data class MemberRequestDto(
    val id: Long,
    val loginId: String,
    val password: String,
    val name: String,
    val birthDate: LocalDate,
    val gender: Gender,
    val email: String
)
