
public class DiscountPricing implements PricingStrategy {
    private double discountPercentage;

    public DiscountPricing(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(InventoryComponent item) {
        return item.getPrice() * (1 - discountPercentage / 100);
    }
}
