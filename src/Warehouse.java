import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private final Set<Item> items = new HashSet<>();
    private final Map<Item, Integer> stock = new HashMap<>();

    // افزودن کالا جدید
    public void addItem(String itemId) throws Exception {
        Item item = new Item(itemId);
        if (items.contains(item)) {
            throw new Exception("Item already exists: " + itemId);
        }
        items.add(item);
        stock.put(item, 0);
    }

    // حذف کالا
    public void removeItem(String itemId) throws Exception {
        Item item = new Item(itemId);
        if (!items.contains(item)) {
            throw new Exception("Item does not exist: " + itemId);
        }
        if (stock.get(item) > 0) {
            throw new Exception("Cannot remove item with non-zero stock: " + itemId);
        }
        items.remove(item);
        stock.remove(item);
    }

    // افزایش موجودی
    public void increaseStock(String itemId, int quantity) throws Exception {
        Item item = new Item(itemId);
        if (!items.contains(item)) {
            throw new Exception("Item does not exist: " + itemId);
        }
        if (quantity <= 0) {
            throw new Exception("Quantity must be greater than 0.");
        }
        stock.put(item, stock.get(item) + quantity);
    }

    // کاهش موجودی
    public void decreaseStock(String itemId, int quantity) throws Exception {
        Item item = new Item(itemId);
        if (!items.contains(item)) {
            throw new Exception("Item does not exist: " + itemId);
        }
        if (quantity <= 0) {
            throw new Exception("Quantity must be greater than 0.");
        }
        if (stock.get(item) < quantity) {
            throw new Exception("Not enough stock to decrease: " + itemId);
        }
        stock.put(item, stock.get(item) - quantity);
    }

    // بررسی موجودی کالا
    public int checkItem(String itemId) throws Exception {
        Item item = new Item(itemId);
        if (!items.contains(item)) {
            throw new Exception("Item does not exist: " + itemId);
        }
        return stock.get(item);
    }
}
