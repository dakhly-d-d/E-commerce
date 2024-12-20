

public class StandardPricing implements PricingStrategy {
    @Override
    public double calculatePrice(InventoryComponent item) {
        return item.getPrice();
    }
}