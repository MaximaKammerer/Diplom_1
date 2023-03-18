import org.junit.Test;
import praktikum.IngredientType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    @Test
    public void IngredientTypeSizeTest () {

        IngredientType[] ingredientType = IngredientType.values();
        assertThat(2,is(ingredientType.length));
    }

    @Test
    public void IngredientTypeSauceTest() {

        assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void IngredientTypeFillingTest () {

        assertNotNull(IngredientType.valueOf("FILLING"));
    }
}
