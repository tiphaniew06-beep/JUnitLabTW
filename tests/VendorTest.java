import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test // Managing vendors
    void testFiveVendors() {
        Vending[] vendors = new Vending[5];

        for (int i = 0; i < 5; i++) {
            vendors[i] = new Vending(10 + i, 5 + i);
        }

        for (int i = 0; i < 5; i++) {
            assertEquals(10 + i, vendors[i].getItemStock("Candy"));
            assertEquals(5 + i, vendors[i].getItemStock("Gum"));
            vendors[i].printInventory();
        }
    }
    @Test // Removing discontinued items
    void testRemoveItem() {
        Vending vendor = new Vending(10, 5);

        vendor.removeItem("Candy");

        assertFalse(vendor.hasItem("Candy"));
        assertTrue(vendor.hasItem("Gum"));
    }

    @Test //Tracking Purchases
    void testTrackPurchases() {
        Vending vendor = new Vending(10, 5);

        vendor.addMoney(5.00);
        vendor.select("Candy");
        vendor.select("Candy");
        vendor.select("Candy");

        assertEquals(3, vendor.getPurchaseCount("Candy"));
        assertEquals(7, vendor.getItemStock("Candy"));
    }

    @Test // Viewing Items desc
    void testItemDescription() {
        Vending vendor = new Vending(10, 5);

        vendor.setItemDescription("Candy", "A sweet treat");

        assertEquals("A sweet treat",
                vendor.getItemDescription("Candy"));
    }

    @Test // Applying discounts
    void testItemDiscount() {
        Vending vendor = new Vending(10, 5);

        vendor.applyDiscount("Candy", 20);

        assertEquals(1.00, vendor.getItemPrice("Candy"), 0.001);
    }

    @Test // Category of disc
    void testCategoryDiscount() {
        Vending vendor = new Vending(10, 5);

        vendor.setItemCategory("Candy", "Snacks");
        vendor.setItemCategory("Gum", "Snacks");

        vendor.applyCategoryDiscount("Snacks", 20);

        assertEquals(1.00, vendor.getItemPrice("Candy"), 0.001);
        assertEquals(0.40, vendor.getItemPrice("Gum"), 0.001);
    }

    @Test // Marking bestsells
    void testBestseller() {
        Vending vendor = new Vending(10, 5);

        vendor.markBestseller("Candy");

        assertTrue(vendor.isBestseller("Candy"));
        assertFalse(vendor.isBestseller("Gum"));
    }
}