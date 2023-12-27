package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

     @AfterEach
     public void afterEach(){
        repository.clearStore();
     }
     // @AfterEach는 JUnit 프레임워크에서 사용되는 어노테이션
     // 이 어노테이션은 JUnit 테스트 메서드가 실행된 후에 실행되어야 하는 특정한 작업을 지정할 때 사용
     // Callback 메서드
     // Test가 실행되고 끝날 때마다 저장소를 다 치움
     // 테스트에서 사용된 리소스의 정리, 데이터베이스 상태를 초기화하는 등의 작업을 수행할 때 유용

     @Test
    public void save(){
         Member member = new Member();
         member.setName("spring");

         repository.save(member);

         Member result = repository.findById(member.getId()).get();
         assertThat(member).isEqualTo(result); // alt + enter ->assertion 안쓰고 바로 사용 가능
     }

     @Test
    public void findByName(){
         Member member1 = new Member();
         member1.setName("spring1");
         repository.save(member1);

        Member member2 = new Member();
         member2.setName("spring2");
         repository.save(member2);

         Member result = repository.findByName("spring1").get();

         assertThat(result).isEqualTo(member1);
     }

     @Test
    public void findAll(){
         Member member1 = new Member();
         member1.setName("spring1");
         repository.save(member1);

         Member member2 = new Member();
         member2.setName("spring2");
         repository.save(member2);

         List<Member> result = repository.findAll();
         assertThat(result.size()).isEqualTo(2);
     }
}
