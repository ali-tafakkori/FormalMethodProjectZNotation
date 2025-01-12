public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        try {
            warehouse.addItem("Item1");
            warehouse.increaseStock("Item1", 10);
            System.out.println("Stock for Item1: " + warehouse.checkItem("Item1"));
            warehouse.decreaseStock("Item1", 5);
            System.out.println("Stock for Item1 after decrease: " + warehouse.checkItem("Item1"));
            warehouse.removeItem("Item1");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            warehouse.removeItem("Item1");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
