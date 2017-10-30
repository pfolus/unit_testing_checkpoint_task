import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;
    private Customer newCustomer;

    @BeforeEach
    void initializeCustomer() {
        this.customer = new Customer();
    }

    @BeforeEach
    void initializeNewCustomer() {
        newCustomer = new Customer("Kamil", "Nowak", 1991, "Male");

    }

    @Test
    void testSetName() {
        assertThrows(IllegalArgumentException.class, () -> this.customer.setName(""));
    }

    @Test
    void testSetSurname() {
        assertThrows(IllegalArgumentException.class, () -> this.customer.setSurname(""));
    }

    @Test
    void testSetBirthYear() {
        assertThrows(IllegalArgumentException.class, () -> this.customer.setBirthyear(1850));
        assertThrows(IllegalArgumentException.class, () -> this.customer.setBirthyear(2020));
    }

    @Test
    void testSetGender() {
        assertThrows(IllegalArgumentException.class, () -> this.customer.setGender("transgender"));
    }

    @Test
    void testGetAge() {
        customer.setBirthyear(2015);
        int result = customer.getAge();
        int expected = 2;
        assertEquals(expected, result);
    }

    @Test
    void testGetName() {
        assertEquals(this.customer.getName(), "default name");
    }

    @Test
    void testGetSurname() {
        assertEquals(this.customer.getSurname(), "default surname");
    }

    @Test
    void testGetBirthyear() {
        this.newCustomer.setBirthyear(1950);
        assertEquals(this.newCustomer.getBirthyear(), 1950);
    }

    @Test
    void testGetGender() {
        this.customer.setGender("Male");
        assertEquals("Male", this.customer.getGender());
    }

    @Test
    void testAddSale() {
        this.customer.addSale();
        this.customer.addSale();

        assertEquals(this.customer.getSalesCount(), 2);

    }
}
