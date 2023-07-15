package com.ani.kotlinjwt.member.entity

import com.ani.kotlinjwt.common.status.Gender
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(name = "uk_member_login_id", columnNames = ["loginId"])]
)
class Member (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(nullable = false, length = 30, updatable = false)
    val loginId: String,

    @Column(nullable = false, length = 100)
    val password: String,


    @Column(nullable = false, length = 10)
    val name: String,


    @Column(nullable = false)
    val birthDate: LocalDate,


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val gender: Gender,


    @Column(nullable = false, length = 30)
    val email: String
){}