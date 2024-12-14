import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private final Set<String> items = new HashSet<>();
    private final Map<String, Integer> stock= new HashMap<>();

    public boolean addItem(String newItem) {
        if (items.contains(newItem)) {
            System.out.println("Item already exists.");
            return false;
        }
        items.add(newItem);
        stock.put(newItem, 0); // Initialize stock to 0
        System.out.println("Item added: " + newItem);
        return true;
    }

    public boolean removeItem(String item) {
        if (!items.contains(item)) {
            System.out.println("Item does not exist.");
            return false;
        }
        if (stock.get(item) > 0) {
            System.out.println("Cannot remove item with non-zero stock.");
            return false;
        }
        items.remove(item);
        stock.remove(item);
        System.out.println("Item removed: " + item);
        return true;
    }

    public boolean increaseStock(String item, int quantity) {
        if (!items.contains(item)) {
            System.out.println("Item does not exist.");
            return false;
        }
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return false;
        }
        stock.put(item, stock.get(item) + quantity);
        System.out.println("Stock increased for " + item + ": " + quantity);
        return true;
    }

    public boolean decreaseStock(String item, int quantity) {
        if (!items.contains(item)) {
            System.out.println("Item does not exist.");
            return false;
        }
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return false;
        }
        if (stock.get(item) < quantity) {
            System.out.println("Not enough stock to decrease.");
            return false;
        }
        stock.put(item, stock.get(item) - quantity);
        System.out.println("Stock decreased for " + item + ": " + quantity);
        return true;
    }

    public Integer checkStock(String item) {
        if (!items.contains(item)) {
            System.out.println("Item does not exist.");
            return null;
        }
        int quantity = stock.get(item);
        System.out.println("Stock for " + item + ": " + quantity);
        return quantity;
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        // Add items
        warehouse.addItem("Item1");
        warehouse.addItem("Item2");

        // Increase stock
        warehouse.increaseStock("Item1", 10);
        warehouse.increaseStock("Item2", 5);

        // Check stock
        warehouse.checkStock("Item1");
        warehouse.checkStock("Item2");

        // Decrease stock
        warehouse.decreaseStock("Item1", 5);

        // Try to remove item with stock
        warehouse.removeItem("Item1");

        // Decrease stock to 0 and remove
        warehouse.decreaseStock("Item1", 5);
        warehouse.removeItem("Item1");

        // Check stock for a removed item
        warehouse.checkStock("Item1");
    }
}
