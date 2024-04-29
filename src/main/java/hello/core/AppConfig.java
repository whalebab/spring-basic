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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션 전체를 설정하고 구성
@Configuration // 설정 정보
public class AppConfig { // IOC 컨테이너, DI 컨테이너

    // @Configuration : 스프링 컨테이너의 설정(구성)정보
    // @Bean : 여기서 @Bean이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록함 / @Bean 메서드 명을 스프링의 이름으로 사용함

    @Bean
    public MemberService memberService() { // 역할
        return new MemberServiceImpl(memberRepository()); // 구현
    }

    @Bean
    public OrderService orderService() { // 역할
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 구현
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
