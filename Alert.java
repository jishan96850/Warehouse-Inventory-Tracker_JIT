
package warehouseinventory;

public class Alert {
    public void triggerLowStockAlert(Product product) {
        System.out.println("⚠️ Low stock alert: " + product.getName() +
                " – only " + product.getQuantity() + " left!");
    }
}
