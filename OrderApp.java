package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.AppConfig;
import hello.core.order.Order;
import hello.core.order.OrderSerice;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderSerice orderSerice = appConfig.orderSerice();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        
        MemberService memberService =  applicationContext.getBean("memberService", MemberService.class);
        OrderSerice orderService = applicationContext.getBean("orderService", OrderSerice.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        Member member1 = new Member(2L, "memberB", Grade.BASIC);
        memberService.join(member);
        memberService.join(member1);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Order order1 = orderService.createOrder(2L, "itemB", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());

        System.out.println("order = " + order1);
        System.out.println("order.calculatePrice = " + order1.calculatePrice());
    }
}
