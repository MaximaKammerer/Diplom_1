import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType typeTest;
    private String nameTest;
    private Float priceTest;

    public IngredientTest (IngredientType typeTest, String nameTest, float priceTest) {

        this.typeTest = typeTest;
        this.nameTest = nameTest;
        this.priceTest = priceTest;
    }

    @Parameterized.Parameters
    public static Object[][] bunTest() {
        return new Object[][] {
                { SAUCE, "szechuan sauce", 10F},
                { SAUCE, " szechuan_sauce ", 9999F},
                { FILLING, "Szechuan_sauce", 0.00000001F},
                { FILLING, "szechuan_sauce2", 9999.1F},
        };
    }

    @Test
    public void getPriceTest () {

        Ingredient ingredientTest = new Ingredient(typeTest, nameTest, priceTest);
        assertThat(priceTest, equalTo(ingredientTest.getPrice()));
    }

    @Test
    public void getNameTest () {

        Ingredient ingredientTest = new Ingredient(typeTest, nameTest, priceTest);
        assertThat(nameTest, equalTo(ingredientTest.getName()));
    }

    @Test
    public void getTypeTest () {

        Ingredient ingredientTest = new Ingredient(typeTest, nameTest, priceTest);
        assertThat(typeTest, equalTo(ingredientTest.getType()));
    }
}
