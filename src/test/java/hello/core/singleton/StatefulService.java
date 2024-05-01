package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    // 주문할때 가격 및 상품을 저장해두는 메서드
    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price; // 여기가 문제!
    }

    public int getPrice() {
        return price;
    }
}
