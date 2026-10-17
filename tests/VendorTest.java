import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

    @Test
    void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test // Candy Restock
    void testRestockExistingItem() {
        Vending vendor = new Vending(10, 5);
        vendor.restockItem("Candy", 5);
        assertEquals(15, vendor.getItemStock("Candy"));
    }

    @Test // Negative Restocks
    void testNegativeRestock() {
        Vending vendor = new Vending (10, 5);
        vendor.restockItem("Candy", -5);
        assertEquals(10, vendor.getItemStock("Candy"));
    }

}