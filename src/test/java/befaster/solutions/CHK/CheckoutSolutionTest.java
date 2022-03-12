package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class CheckoutSolutionTest {

    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {

        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void check_item_prices() {
        assertThat(checkoutSolution.checkout("A"), equalTo(50));
        assertThat(checkoutSolution.checkout("B"), equalTo(30));
        assertThat(checkoutSolution.checkout("C"), equalTo(20));
        assertThat(checkoutSolution.checkout("D"), equalTo(15));
    }

    @Test
    public void check_sum_single_items() {
        assertThat(checkoutSolution.checkout("AA"), equalTo(100));
        assertThat(checkoutSolution.checkout("BB"), equalTo(60));
        assertThat(checkoutSolution.checkout("CC"), equalTo(40));
        assertThat(checkoutSolution.checkout("DD"), equalTo(30));
    }



}

