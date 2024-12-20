

public class Item implements Prototype, InventoryComponent {
    private int itemId;
    private String itemName;
    private String itemCategory;
    private double itemPrice;

    public Item(String itemName, String itemCategory, double itemPrice) {
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
    }

    public Item(int itemId, String itemName, String itemCategory, double itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
    }

    public String getName() {
        return itemName;
    }

    public String getCategory() {
        return itemCategory;
    }

    public double getPrice() {
        return itemPrice;
    }

    @Override
    public Item clone() {
        return new Item(this.itemName, this.itemCategory, this.itemPrice);
    }

    public int getItemId() {
        return itemId;
    }
}
