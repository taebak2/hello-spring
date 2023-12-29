package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;
    // new memberService를 사용하면 내용이 바뀔 때마다 new 객체가 생성됨
    // 의존성을 외부로부터 주입받기 위한 방법으로 생성자의 파라미터를 사용
    // 객체를 새로 생성하는 것이 아닌, 이미 생성된 스프링 빈(싱글톤 스코프)를 사용하기 위함

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;

        // MemberService -> 스프링 컨텐츠와 관련된 서비스를 스프링이 넣어줌
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") // 데이터를 넣어서 전달할 때 주로 Post사용, Get은 주로 조회할 때 사용
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";

    }
}
