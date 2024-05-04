package hello.core.lifecycle;

//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {
    // InitializingBean: 초기화 Bean
    // DisposableBean: 종료 Bean

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message: " + message);
    }

    //서비스 종료 시 호출
    public void disConnect() {
        System.out.println("close: " + url);
    }

    @PostConstruct
    public void init() throws Exception {
        // 의존관계 주입이 끝나면 호출해주는 메서드
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception {
        // SpringContainer가 종료되기 전에 호출해주는 메서드
        System.out.println("NetworkClient.close");
        disConnect();
    }

    /*
    @Override
    public void afterPropertiesSet() throws Exception {
        // 의존관계 주입이 끝나면 호출해주는 메서드
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        // SpringContainer가 종료되기 전에 호출해주는 메서드
        System.out.println("NetworkClient.destroy");
        disConnect();
    }
    */
}
