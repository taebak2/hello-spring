package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    // ctrl + shift + t 테스트 코드 추가


    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }   // 의존성 주입


    //회원 가입
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원 X

        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }


    // 중복 회원 검증

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    // ifPresent는 조회된 회원이 존재할 경우에만 동작하는 메서드

    // 따라서, 이미 같은 이름의 회원이 존재하면 IllegalStateException을 발생시키며 "이미 존재하는 회원입니다."라는 메시지를 포함한 예외를 던짐

    // 따라서, 이미 같은 이름의 회원이 존재하면 IllegalStateException을 발생시키며
    // "이미 존재하는 회원입니다."라는 메시지를 포함한 예외를 던짐


    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
