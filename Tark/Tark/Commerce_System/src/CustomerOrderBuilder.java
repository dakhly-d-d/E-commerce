

public class CustomerOrderBuilder {
    private String deliveryAddress;
    private double totalAmount;
    private String orderType;
    private String customerName;

    public CustomerOrderBuilder setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public CustomerOrderBuilder setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public CustomerOrderBuilder setOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    public CustomerOrderBuilder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public CustomerOrder createOrder() {
        return new CustomerOrder(deliveryAddress, totalAmount, orderType, customerName);
    }
}
