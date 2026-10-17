import java.util.HashMap;
/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vending {
    private HashMap<String, Item> Stock = new HashMap<>();
    private double balance;

    Vending(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = 0;
    }

    /** resets the Balance to 0 */
    void resetBalance () {
        this.balance = 0;
    }

    /** returns the current balance */
    double getBalance () {
        return this.balance;
    }

    /** adds money to the machine's balance
     * @param amt how much money to add
     * */
    void addMoney (double amt) {
        this.balance = this.balance + amt;
    }

    /** attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    void select (String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (balance >= item.price) {
                item.purchase(1);
                this.balance = this.balance - item.price;
            }
            else
                System.out.println("Gimme more money");
        }
        else System.out.println("Sorry, don't know that item");
    }
    void restockItem(String name, int amount) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            item.restock(amount);
        }
    }
    void restockItem(String name, int amount, double price) {
        if (amount <= 0) {
            return;
        }
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            item.restock(amount);
        } else {
            Stock.put(name, new Item(price, amount));
        }
    }
    int getItemStock(String name){
        Item item = Stock.get(name);
        return item.stock;
    }

    boolean hasItem(String name) {
        return Stock.containsKey(name);
    }
void renameItem(String oldName, String newName) {
        if (Stock.containsKey(oldName)
            && !Stock.containsKey(newName)) {
            Item item = Stock.remove(oldName);
            Stock.put(newName, item);
        }
    }

    void printInventory() {
        for (String name : Stock.keySet()) {
            Item item = Stock.get(name);
            System.out.println(name + " - Price: $" + item.price + " - Stock: " + item.stock);
        }
    }

    void removeItem(String name) {
        Stock.remove(name);
    }

    int getPurchaseCount(String name) {
        Item item = Stock.get(name);
        return item == null ? 0 : item.purchaseCount;
    }

    void setItemDescription(String name, String description) {
        if (Stock.containsKey(name)) {
            Stock.get(name).description = description;
        }
    }

    String getItemDescription(String name) {
        if (Stock.containsKey(name)) {
            return Stock.get(name).description;
        }
        return "Item not found";
    }

    void setItemCategory(String name, String category) {
        if (Stock.containsKey(name)) {
            Stock.get(name).category = category;
        }
    }

    void applyDiscount(String name, double percent) {
        if (Stock.containsKey(name) && percent >= 0 && percent <= 100) {
            Item item = Stock.get(name);
            item.price = item.price * (1 - percent / 100);
        }
    }

    void applyCategoryDiscount(String category, double percent) {
        if (percent < 0 || percent > 100) {
            return;
        }

        for (Item item : Stock.values()) {
            if (category.equals(item.category)) {
                item.price = item.price * (1 - percent / 100);
            }
        }
    }

    double getItemPrice(String name) {
        return Stock.get(name).price;
    }

}

class Examples {
}

