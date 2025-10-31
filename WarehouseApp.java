package warehouseinventory;

import java.util.Scanner;

public class WarehouseApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Warehouse warehouse = new Warehouse();
        boolean exit = false;

        while(!exit) {
            System.out.println("\n--- Warehouse Inventory Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Receive Shipment");
            System.out.println("3. Fulfill Order");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter initial quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter minimum stock level for alert: ");
                    int threshold = sc.nextInt();
                    sc.nextLine();
                    warehouse.addProduct(name, qty, threshold);
                    break;

                case 2:
                    warehouse.listProductIDs();
                    System.out.print("Enter Product ID to receive shipment: ");
                    int receiveId = sc.nextInt();
                    System.out.print("Enter quantity to receive: ");
                    int rQty = sc.nextInt();
                    sc.nextLine();
                    warehouse.receiveShipment(receiveId, rQty);
                    break;

                case 3:
                    warehouse.listProductIDs();
                    System.out.print("Enter Product ID to fulfill order: ");
                    int orderId = sc.nextInt();
                    System.out.print("Enter quantity to fulfill: ");
                    int oQty = sc.nextInt();
                    sc.nextLine();
                    warehouse.fulfillOrder(orderId, oQty);
                    break;

                case 4:
                    warehouse.displayInventory();
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
