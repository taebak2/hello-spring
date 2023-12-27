package hello.hellospring.repository;

import hello.hellospring.domain.Member;
<<<<<<< HEAD

import java.util.*;


=======
import org.springframework.stereotype.Repository;

import java.util.*;

>>>>>>> 9ab3181 (2023-12-27)
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // 새로운 회원이 추가될 때마다 그에 해당하는 고유한 ID를 생성하기 위한 것
    // sequence는 회원의 ID 값으로 사용
    // 이 변수는 회원이 추가될 때마다 1씩 증가하며,
    // 새로운 회원에게는 증가된 값을 부여하여 고유한 ID를 제공


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    // Optional은 값이 있을 수도 있고 없을 수도 있는 상황에서 사용
    // 이를 통해 메서드가 반환하는 값이 null일 수 있는지 명시적으로 표현 
    // 그렇기 때문에 findById나 findByName과 같이 조회하는 메서드에서 회원을 찾지 못했을 때 
    // null을 반환하는 대신에 Optional을 사용하여 명시적으로 "값이 없음"을 표현할 수 있음

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
    // store.values()는 Map에 있는 값들을 Collection으로 반환
    // 이후 stream() 메서드를 호출하여 이 Collection을 스트림으로 변환
    // 이러한 스트림을 사용하면 데이터를 처리하고 연산할 수 있는 기능들을 제공받을 수 있음
    // 예를 들어, 여기서는 filter()를 이용하여 특정 조건에 맞는 회원을 찾는 데 사용

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }


    public void clearStore() {
        store.clear();
    }
}