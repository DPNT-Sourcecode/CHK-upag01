package befaster.solutions.HLO;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class HelloSolutionTest extends TestCase {

    private HelloSolution hello;

    @Before
    public void setUp() {

        hello = new HelloSolution();
    }


    @Test
    public void hello() {
        assertThat(hello.hello("John"), equalTo("Hello, Jonh!"));
    }
}
