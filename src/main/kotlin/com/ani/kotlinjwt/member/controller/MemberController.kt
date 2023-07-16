package com.ani.kotlinjwt.member.controller

import com.ani.kotlinjwt.member.dto.MemberRequestDto
import com.ani.kotlinjwt.member.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@RequestMapping("/api/member")
@Controller
class MemberController (
    private val memberService: MemberService
){
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid memberRequestDto: MemberRequestDto): ResponseEntity<String> {
        return memberService.signUp(memberRequestDto)
            .let { ResponseEntity.ok(it) }
    }
}