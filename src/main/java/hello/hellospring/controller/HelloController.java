package hello.hellospring.controller;

// 파라미터 정보 값 보기 ctrl + p

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }



    @GetMapping("hello-string")
    @ResponseBody // http의 header, body부분 중 바디부에 이 데이터를 직접 넣는다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring"
    }
    // @ResponseBody를 사용하면 컨트롤러가 반환하는 객체가 HTTP 응답의 본문(body)으로 전송
    // 이는 주로 REST API에서 JSON, XML 등의 형식으로 데이터를 클라이언트에게 반환하는 데 사용
    // @ResponseBody를 사용하지 않으면, 스프링 MVC는 해당 메서드가 반환하는 객체를 뷰로 처리하려고 시도
    // 예를 들어, Thymeleaf나 JSP와 같은 뷰 템플릿을 사용하여 렌더링하려고 시도할 수 있음
    // @RequestParam은 HTTP 요청의 파라미터를 컨트롤러 메서드의 파라미터에 매핑하는 데 사용


    // Json 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
