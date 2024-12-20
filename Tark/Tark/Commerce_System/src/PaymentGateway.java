

public class PaymentGateway {
    private static PaymentGateway uniqueInstance;

    private PaymentGateway() {
    }

    public static PaymentGateway getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PaymentGateway();
        }
        return uniqueInstance;
    }

    public boolean processPayment(String paymentMethod, double amount) {
        switch (paymentMethod.toLowerCase()) {
            case "credit card":
                return processCreditCard(amount);
            case "paypal":
                return processPayPal(amount);
            default:
                System.out.println("Unsupported payment method: " + paymentMethod);
                return false;
        }
    }

    private boolean processCreditCard(double amount) {
        System.out.println("Processing credit card payment: " + amount);
        return true;
    }

    private boolean processPayPal(double amount) {
        System.out.println("Processing PayPal payment: " + amount);
        return true;
    }
}
