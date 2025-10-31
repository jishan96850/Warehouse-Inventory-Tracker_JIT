package warehouseinventory;

import java.util.*;

public class Warehouse {

    private Map<Integer, Product> products = new HashMap<Integer, Product>();
    private Alert alertService = new Alert();

    // Add product
    public void addProduct(String name, int quantity, int threshold) {
        Product product = new Product(name, quantity, threshold);
        products.put(product.getId(), product);
        System.out.println("Added: " + product);
    }

    // Receive shipment
    public void receiveShipment(int productId, int amount) {
        Product p = products.get(productId);
        if(p != null) {
            p.increaseQuantity(amount);
            System.out.println("Shipment received: " + amount + " units of " + p.getName());
        } else {
            System.out.println("Invalid Product ID!");
        }
    }

    // Fulfill order
    public void fulfillOrder(int productId, int amount) {
        Product p = products.get(productId);
        if(p != null) {
            if(p.decreaseQuantity(amount)) {
                System.out.println("Order fulfilled: " + amount + " units of " + p.getName());
                if(p.getQuantity() < p.getReorderThreshold()) {
                    alertService.triggerLowStockAlert(p);
                }
            } else {
                System.out.println("Insufficient stock for " + p.getName());
            }
        } else {
            System.out.println("Invalid Product ID!");
        }
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        if(products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for(Product p : products.values()) {
            System.out.println(p);
        }
    }

    // List product IDs
    public void listProductIDs() {
        if(products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("Available Product IDs:");
        for(Product p : products.values()) {
            System.out.println(p.getId() + " -> " + p.getName());
        }
    }
}
