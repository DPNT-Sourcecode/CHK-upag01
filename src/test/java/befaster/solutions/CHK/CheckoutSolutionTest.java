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
        assertThat(checkoutSolution.checkout("E"), equalTo(40));
        assertThat(checkoutSolution.checkout("F"), equalTo(10));
        assertThat(checkoutSolution.checkout("G"), equalTo(20));
        assertThat(checkoutSolution.checkout("H"), equalTo(10));
        assertThat(checkoutSolution.checkout("I"), equalTo(35));
        assertThat(checkoutSolution.checkout("J"), equalTo(60));
        assertThat(checkoutSolution.checkout("K"), equalTo(80));
        assertThat(checkoutSolution.checkout("L"), equalTo(90));
        assertThat(checkoutSolution.checkout("M"), equalTo(15));
        assertThat(checkoutSolution.checkout("N"), equalTo(40));
        assertThat(checkoutSolution.checkout("O"), equalTo(10));
        assertThat(checkoutSolution.checkout("P"), equalTo(50));
        assertThat(checkoutSolution.checkout("Q"), equalTo(30));
        assertThat(checkoutSolution.checkout("R"), equalTo(50));
        assertThat(checkoutSolution.checkout("S"), equalTo(30));
        assertThat(checkoutSolution.checkout("T"), equalTo(20));
        assertThat(checkoutSolution.checkout("U"), equalTo(40));
        assertThat(checkoutSolution.checkout("V"), equalTo(50));
        assertThat(checkoutSolution.checkout("W"), equalTo(20));
        assertThat(checkoutSolution.checkout("X"), equalTo(90));
        assertThat(checkoutSolution.checkout("Y"), equalTo(10));
        assertThat(checkoutSolution.checkout("Z"), equalTo(50));


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
    public void test_F_offer() {
        assertThat(checkoutSolution.checkout("FF"), equalTo(20));
        assertThat(checkoutSolution.checkout("FFF"), equalTo(20));
        assertThat(checkoutSolution.checkout("FFFF"), equalTo(30));
    }


    @Test
    public void test_E_offer() {
        assertThat(checkoutSolution.checkout("EEBB"), equalTo(110));
        assertThat(checkoutSolution.checkout("EEEEEBBB"), equalTo(230));
        assertThat(checkoutSolution.checkout("EEEEBB"), equalTo(160));
        assertThat(checkoutSolution.checkout("BEBEEE"), equalTo(160));
    }


    @Test
    public void test_sum_multiple_items() {
        assertThat(checkoutSolution.checkout("ACCABDDBB"), equalTo(245));
        assertThat(checkoutSolution.checkout("ABCDE"), equalTo(155));
    }



}




