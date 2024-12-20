import java.util.ArrayList;
import java.util.List;

public class CartManager {

    private static CartManager uniqueInstance;
    private List<InventoryComponent> cart;

    private CartManager() {
        cart = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new CartManager();
        }
        return uniqueInstance;
    }

    public void addItemToCart(InventoryComponent item) {
        cart.add(item);
        System.out.println(item.getName() + " added to the cart.");
    }

    public void clearCart() {
        cart.clear();
    }

    public double calculateTotal() {
        double total = 0.0;
        for (InventoryComponent item : cart) {
            total += item.getPrice();
        }
        return total;
    }

    public List<InventoryComponent> getCartItems() {
        return cart;
    }
}
