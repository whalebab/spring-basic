package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// @ComponentScan: @Component 애노테이션이 붙은 클래스를 찾아서 자동으로 스프링 빈에 등록해줌
// basePackages: 탐색할 패키지의 시작 위치를 지정
// basePackages = "hello.core.member", : (member만 ComponentScan 대상이 됨)
// @ComponentScan.Filter: @ComponentScan으로 확인해서 스프링 빈으로 자동 등록하는데 그 중에서 뺄 것을 지정해 줌
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}

