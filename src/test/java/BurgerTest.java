import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredientOne, ingredientTwo, ingredientThree;
    Bun bun = Mockito.mock(Bun.class);

    @Test
    public void setBunsTest() {

        Burger burger = new Burger();
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest () {

        Burger burger = new Burger ();
        burger.addIngredient(ingredientOne);

        assertEquals(ingredientOne, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest () {

        Burger burger = new Burger ();
        burger.addIngredient(ingredientOne);
        burger.removeIngredient(0);

        assertEquals(true, burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest () {

        Burger burger = new Burger ();
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);
        burger.moveIngredient(0,2);

        assertEquals(ingredientOne, burger.ingredients.get(2));
    }

    @Test
    public void getPriceTest () {

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredientOne);

        Mockito.when(bun.getPrice()).thenReturn(10.5F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(6f);

        assertEquals(27F, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptTest() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredientOne);

        Mockito.when(bun.getName()).thenReturn("Burger");
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientOne.getName()).thenReturn( "szechuan sauce");

        String actual = burger.getReceipt();
        String expected =
                "(==== Burger ====)\r\n" +
                        "= sauce szechuan sauce =\r\n" +
                        "(==== Burger ====)\r\n" +
                        "\r\n" +
                        "Price: 0,000000\r\n";

        assertEquals(expected, actual);
    }
}
