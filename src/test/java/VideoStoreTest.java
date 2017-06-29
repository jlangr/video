import org.junit.*;

import static org.junit.Assert.*;

public class VideoStoreTest {
    private Customer customer;

    @Before
    public void createCustomer() {
        customer = new Customer("Fred");
    }

    @Test
    public void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", PriceStrategyFactory.NEW_RELEASE), 3));
        assertEquals(
                "Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n",
                customer.statement());
    }

    @Test
    public void testDualNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", PriceStrategyFactory.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("The Tigger Movie", PriceStrategyFactory.NEW_RELEASE), 3));
        assertEquals(
                "Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n",
                customer.statement());
    }

    @Test
    public void testSingleChildrensStatement() {
        customer.addRental(new Rental(new Movie("The Tigger Movie", PriceStrategyFactory.CHILDRENS), 3));
        assertEquals(
                "Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n",
                customer.statement());
    }

    @Test
    public void testMultipleRegularStatement() {
        customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", PriceStrategyFactory.REGULAR), 1));
        customer.addRental(new Rental(new Movie("8 1/2", PriceStrategyFactory.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Eraserhead", PriceStrategyFactory.REGULAR), 3));

        assertEquals(
                "Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n",
                customer.statement());
    }
}