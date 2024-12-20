import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Initialize database connection
        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=ShopDB;encrypt=false";
        String dbUser = "sa";
        String dbPass = "123";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            System.out.println("Database connected successfully.");

            // Add items to the database
            Item item1 = new Item("Laptop", "electronics", 1200.00);
            Item item2 = new Item("Sofa", "furniture", 800.00);
            addItemToDatabase(connection, item1);
            addItemToDatabase(connection, item2);

            // Add an order to the database
            CustomerOrder order = new CustomerOrder("123 Main St", 2000.00, "regular", "John Doe");
            addOrderToDatabase(connection, order);

            // Cart management
            CartManager cartManager = CartManager.getInstance();
            cartManager.addItemToCart(item1);
            cartManager.addItemToCart(item2);

            System.out.println("Cart total before discount: " + cartManager.calculateTotal());

            // Use strategy pattern for pricing
            PricingContext pricingContext = new PricingContext(new DiscountPricing(10));
            double discountedPrice1 = pricingContext.executeStrategy(item1);
            double discountedPrice2 = pricingContext.executeStrategy(item2);

            System.out.println("Discounted price for " + item1.getName() + ": " + discountedPrice1);
            System.out.println("Discounted price for " + item2.getName() + ": " + discountedPrice2);

            // Payment processing
            PaymentGateway paymentGateway = PaymentGateway.getInstance();
            boolean paymentSuccess = paymentGateway.processPayment("credit card", cartManager.calculateTotal());

            if (paymentSuccess) {
                System.out.println("Payment processed successfully.");
            } else {
                System.out.println("Payment failed.");
            }

            // Clear the cart
            cartManager.clearCart();

        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Database connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void addItemToDatabase(Connection connection, Item item) {
        String sql = "INSERT INTO inventory (itemName, itemCategory, itemPrice) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getCategory());
            pstmt.setDouble(3, item.getPrice());
            pstmt.executeUpdate();
            System.out.println("Item added to database: " + item.getName());
        } catch (SQLException e) {
            System.out.println("Error adding item to database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addOrderToDatabase(Connection connection, CustomerOrder order) {
        String sql = "INSERT INTO Orders (deliveryAddress, totalAmount, orderType, customerName) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, order.getDeliveryAddress());
            pstmt.setDouble(2, order.getTotalAmount());
            pstmt.setString(3, order.getOrderType());
            pstmt.setString(4, order.getCustomerName());
            pstmt.executeUpdate();
            System.out.println("Order added to database: " + order.getCustomerName());
        } catch (SQLException e) {
            System.out.println("Error adding order to database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
