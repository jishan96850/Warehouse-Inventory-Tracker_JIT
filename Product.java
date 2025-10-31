package warehouseinventory;

public class Product {

    private static int idCounter = 1;
    private int id;
    private String name;
    private int quantity;
    private int reorderThreshold;

    public Product(String name, int quantity, int reorderThreshold) {
        this.id = idCounter++;
        this.name = name;
        this.quantity = quantity;
        this.reorderThreshold = reorderThreshold;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getReorderThreshold() { return reorderThreshold; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setReorderThreshold(int threshold) { this.reorderThreshold = threshold; }

    // Stock update
    public void increaseQuantity(int amount) {
        if(amount > 0) quantity += amount;
    }

    public boolean decreaseQuantity(int amount) {
        if(amount <= 0 || amount > quantity) return false;
        quantity -= amount;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Product[ID=%d, Name=%s, Quantity=%d, Threshold=%d]",
                id, name, quantity, reorderThreshold);
    }
}
