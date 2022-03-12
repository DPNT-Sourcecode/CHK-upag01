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
        assertEquals("50", checkoutSolution.checkout("A"));
        assertEquals("30", checkoutSolution.checkout("B"));
        assertEquals("20", checkoutSolution.checkout("C"));
        assertEquals("10", checkoutSolution.checkout("D"));
    }
}


