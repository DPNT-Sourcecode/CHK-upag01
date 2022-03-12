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
    public void test_illegal_input() {
        assertThat(checkoutSolution.checkout(""), equalTo(0));
        assertThat(checkoutSolution.checkout(null), equalTo(-1));
        assertThat(checkoutSolution.checkout("3"), equalTo(-1));
        assertThat(checkoutSolution.checkout("   "), equalTo(-1));
        assertThat(checkoutSolution.checkout("a3B"), equalTo(-1));
    }

    @Test
    public void test_item_prices() {
        assertThat(checkoutSolution.checkout("A"), equalTo(50));
        assertThat(checkoutSolution.checkout("B"), equalTo(30));
        assertThat(checkoutSolution.checkout("C"), equalTo(20));
        assertThat(checkoutSolution.checkout("D"), equalTo(15));
    }

    @Test
    public void test_sum_single_items() {
        assertThat(checkoutSolution.checkout("AA"), equalTo(100));
        assertThat(checkoutSolution.checkout("BBB"), equalTo(75));
        assertThat(checkoutSolution.checkout("CC"), equalTo(40));
        assertThat(checkoutSolution.checkout("DD"), equalTo(30));
    }


    @Test
    public void test_A_offer() {
        assertThat(checkoutSolution.checkout("AAA"), equalTo(130));
        assertThat(checkoutSolution.checkout("AAAAA"), equalTo(200));
        assertThat(checkoutSolution.checkout("AAAAAA"), equalTo(250));
    }


    @Test
    public void test_B_offer() {
        assertThat(checkoutSolution.checkout("BB"), equalTo(45));
        assertThat(checkoutSolution.checkout("BBBB"), equalTo(90));
    }


    @Test
    public void test_E_offer() {
        assertThat(checkoutSolution.checkout("EEBB"), equalTo(110));
        assertThat(checkoutSolution.checkout("EEEEEBBBB"), equalTo(245));
    }


    @Test
    public void test_sum_multiple_items() {
        assertThat(checkoutSolution.checkout("ACCABDDBB"), equalTo(245));
    }



}


