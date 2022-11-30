package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderSerice{

    private final MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();              //고정할인
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();               //비율할인
    //할인 정책을 변경하려면 클라이언트인 FixDiscountPolicy -> RateDiscountPoilcy로 변경 -> OCP위반
    //역할과 구현을 충실하게 분리 OK
    //다형성도 활용, 인터페이스와 구현 객체 분리 OK

    //OCP, DIP 같은 객체지향 설계 원칙을 충실한거 같지만 아님.
    //DIP 클래스 의존관계를 분석 -> OrderServiceImpl는 DiscountPolicy 인터페이스, FixDiscountPolicy or RateDiscountPolicy 구체 클래스 둘다 의존
    //DIP 위반

    //즉 OCP, DIP 위반

    private final DiscountPolicy discountPolicy;                  //구체클레스x 추상화인 인터페이스에만 의존

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
