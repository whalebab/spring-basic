package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 애플리케이션 전체를 설정하고 구성
public class AppConfig {

    /**
     * AppConfig는 생성한 객체 인슨턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다. (생성자 주입)
     * */
    // MemberServiceImpl -> MemoryMemberRepository
    // OrderServiceImpl -> MemoryMemberRepository, FixDiscountPolicy

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
        // MemberServiceImpl를 만들고 내가 만드는 MemberServiceImpl은 MemoryMemberRepository를 사용할거야 (주입해줌)
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
