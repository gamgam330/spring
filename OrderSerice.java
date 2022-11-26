package hello.core.order;

public interface OrderSerice {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
