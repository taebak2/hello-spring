package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 저장소에 회원 저장
    Optional<Member> findById(Long id); // 저장된 아이디 찾기
    Optional<Member> findByName(String name); // 저장된 이름 찾기
    List<Member> findAll();
}
