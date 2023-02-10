package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(originPatterns = "http//localhost8080")
@RestController
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    /*@GetMapping("/account")
    public String create(@RequestParam("name") String name,
                         @RequestParam("email") String email,
                         @RequestParam("user_name") String nickName,
                         @RequestParam("password") String password){
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        member.setPassword(password);
        member.setPhoneNumber(nickName);
        memberService.join(member);

        return "redirect:/";
    }*/

    @PostMapping("/account1")
    public String create1(@RequestBody HashMap<String, String> requset) throws Exception{
        Member member = new Member();
        member.setName(requset.get("name"));
        member.setEmail(requset.get("email"));
        member.setPassword(requset.get("password"));
        member.setPhoneNumber(requset.get("user_name"));
        memberService.join(member);

        return "redirect:/";
    }

    
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}