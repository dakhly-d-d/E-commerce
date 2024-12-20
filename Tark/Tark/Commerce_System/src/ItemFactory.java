
public class ItemFactory {
    public static Item createItem(String name, String category, double price) {
        switch (category.toLowerCase()) {
            case "electronics":
                return new Item(name, "electronics", price);
            case "furniture":
                return new Item(name, "furniture", price);
            case "kitchenware":
                return new Item(name, "kitchenware", price);
            default:
                throw new IllegalArgumentException("Unknown category");
        }
    }
}
