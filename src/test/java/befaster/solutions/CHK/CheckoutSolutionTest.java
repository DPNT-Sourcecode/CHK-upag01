package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckoutSolutionTest {

    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {

        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void check_item_prices() {
        assertEquals(50L, checkoutSolution.checkout("A"));
        assertEquals(30L, checkoutSolution.checkout("B"));
        assertEquals(20L, checkoutSolution.checkout("C"));
        assertEquals(10L, checkoutSolution.checkout("D"));
    }
}




