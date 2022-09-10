package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig { //배우가 상대 배우를 선택하는게 아니라, 담당자를 따로 두는 것

    //누가 선택되는지 깔끔하게 정리됨 (리팩토링)
    private static MemberRepository memoryRepository() {
        return new MemoryMemberRepository();
    }
    private static DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    public MemberService memberService(){
        return new MemberServiceImpl(memoryRepository()); //생성자 주입, DI(의존관계 주입)
    }

    public OrderService orderService(){ //배우의 역할에 사람이 캐스팅 되는 것과 비슷
        return new OrderServiceImpl(memoryRepository(), discountPolicy());
    }
}
