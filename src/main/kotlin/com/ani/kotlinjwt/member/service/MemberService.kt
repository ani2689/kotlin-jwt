package com.ani.kotlinjwt.member.service

import com.ani.kotlinjwt.member.dto.MemberRequestDto
import com.ani.kotlinjwt.member.entity.Member
import com.ani.kotlinjwt.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService (
    private val memberRepository: MemberRepository
){
    fun signUp(memberRequestDto: MemberRequestDto): String {
        var member: Member? = memberRepository.findByLoginId(memberRequestDto.loginId)

        if(member != null)
            return "이미 등록된 아이디입니다."

        member = Member(
            null,
            memberRequestDto.loginId,
            memberRequestDto.password,
            memberRequestDto.name,
            memberRequestDto.birthDate,
            memberRequestDto.gender,
            memberRequestDto.email
        )

        memberRepository.save(member)

        return "회원가입이 완료되었습니다."
    }
}