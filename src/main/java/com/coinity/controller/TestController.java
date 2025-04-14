package com.coinity.controller;

import com.coinity.domain.Member;
import com.coinity.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    private final MemberRepository memberRepository;

    @PostMapping("/member")
    public String addMember(@RequestParam Map<String, Objects> param) {
        Member member = new Member();
        member.setNickname("테스트 닉넴");
        memberRepository.save(member);
        log.info("userNo = {}",member.getUserNo());
        return "hello";
    }
}
