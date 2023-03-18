import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private String nameTest;
    private Float priceTest;

    public BunTest (String nameTest, Float priceTest) {

        this.nameTest = nameTest;
        this.priceTest = priceTest;
    }

    @Parameterized.Parameters
    public static Object[][] bunTest() {
        return new Object[][] {
                { "Burger", 10F},
                { "CheseBurger", 100.55F},
                { "BigBurger", 0.00000001F},
                { " Big Burger ", -3.7E6f},
                { " 1234 ", 3.76f},
        };
    }

    @Test
    public void getNameTest () {

        Bun bunTest = new Bun(nameTest, priceTest);
        assertThat(nameTest, equalTo(bunTest.getName()));
    }

    @Test
    public void getPriceTest () {

        Bun bunTest = new Bun(nameTest, priceTest);
        assertTrue(priceTest == bunTest.getPrice());
    }
}
