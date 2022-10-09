package com.example.springproject1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller                                                                 //컨트롤러 라는 소리
public class HelloController {
    @GetMapping("hi")                                                    //URL 가져오기
    public String hello(Model model){
        model.addAttribute("data", "hello!!");      //data는 Key hello!!는 Value
        return "hello";                                                    //hello라는 파일 이름으로 가서 실행해라
    }
}
//컨트롤러에서 return 값으로 문자열을 주면 뷰 리졸버가 화면을 찾아 실행. 즉 resourse -> templates -> 파일이름을 찾아감