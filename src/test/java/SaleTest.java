import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    private Sale item1;
    private Sale item2;

    @BeforeEach
    void initItems() {
        this.item1 = new Sale();
        this.item2 = new Sale("test name", new BigDecimal("22.50"), 23);
    }

    @Test
    void testGetProductName() {
        item1.setProductName("testname");
        assertEquals("testname", item1.getProductName());
    }

    @Test
    void testSetProductName() {
        assertThrows(IllegalArgumentException.class, () -> item1.setProductName(""));
    }

    @Test
    void testGetNetValue() {
        BigDecimal expected = new BigDecimal("22.50");
        assertEquals(expected, this.item2.getNetValue());
    }

    @Test
    void testGetTaxRate() {
        assertEquals(23, item2.getTaxRate());
    }

    @Test
    void testSetTaxRate() {
        assertThrows(IllegalArgumentException.class, () -> item1.setTaxRate(150));
    }

    @Test
    void testGetGrossValue() {
        item1.setNetValue(new BigDecimal("155.00"));
        item1.setTaxRate(10);

        BigDecimal expected = new BigDecimal("170.50");

        assertEquals(expected, item1.getGrossValue());

    }

}