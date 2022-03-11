package befaster.solutions.HLO;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class HelloSolutionTest {

    private HelloSolution hello;

    @Before
    public void setUp() {

        hello = new HelloSolution();
    }


    @Test
    public void hello() {
        assertEquals(hello.hello("Mark"), "Hello, Mark!");
    }
}
