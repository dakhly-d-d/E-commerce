

public class CustomerOrder {
    private int orderId;
    private String deliveryAddress;
    private double totalAmount;
    private String orderType;
    private String customerName;

    public CustomerOrder(String deliveryAddress, double totalAmount, String orderType, String customerName) {
        this.deliveryAddress = deliveryAddress;
        this.totalAmount = totalAmount;
        this.orderType = orderType;
        this.customerName = customerName;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getCustomerName() {
        return customerName;
    }
}
