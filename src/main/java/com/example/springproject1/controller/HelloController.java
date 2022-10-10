package com.example.springproject1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller                                                                 //컨트롤러 라는 소리
public class HelloController {
    @GetMapping("")                                                    //URL 가져오기
    public String hello(Model model){
        model.addAttribute("data", "hello!!");      //data는 Key hello!!는 Value
        return "hello";                                                    //hello라는 파일 이름으로 가서 실행해라
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody                                                       //body부에 return에 있는 name을 직접 넣어주겟다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;                                                   //단순 문자면 StringCinvertor로 객체면 JsonConvertor로
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
//컨트롤러에서 return 값으로 문자열을 주면 뷰 리졸버가 화면을 찾아 실행. 즉 resourse -> templates -> 파일이름을 찾아감