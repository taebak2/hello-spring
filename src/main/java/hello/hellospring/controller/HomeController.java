package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
// 화면 구현하는 home.html -> resources -> templates에 생성
// /Mapping -> 바로 회원가입 페이지로 이동 가능
}




