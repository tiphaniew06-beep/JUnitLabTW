import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class VendorTest {

    @Test
    void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
        // Candy Restock
    void testRestockExistingItem() {
        Vending vendor = new Vending(10, 5);
        vendor.restockItem("Candy", 5);
        assertEquals(15, vendor.getItemStock("Candy"));
    }

    @Test
        // Negative Restocks
    void testNegativeRestock() {
        Vending vendor = new Vending(10, 5);
        vendor.restockItem("Candy", -5);
        assertEquals(10, vendor.getItemStock("Candy"));
    }

    @Test
        // Unavailable items
    void testRestockNewItem() {
        Vending vendor = new Vending(10, 5);
        vendor.restockItem("Chips", 10, 2.00);
        assertEquals(10, vendor.getItemStock("Chips"));
    }

    @Test // Renaming an item
            void testRenameItem() {
             Vending vendor = new Vending(10, 5);
             vendor.renameItem("Candy","Chocolate");

             assertEquals(10,vendor.getItemStock("Chocolate"));

             assertFalse(vendor.hasItem("Candy"));
    }

}