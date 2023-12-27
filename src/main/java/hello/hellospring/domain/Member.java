package hello.hellospring.domain;

public class Member {
    private Long id; // 시스템에 저장을 할 때 등록되는 것
    private String name; // 고객이 회원가입할 때 적는 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
