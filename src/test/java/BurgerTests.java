import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    Burger burger = new Burger();

    @Test
    public void setBurgerBunTest() {
        when(bun.getName()).thenReturn("Черная булочка");
        burger.setBuns(bun);

        String expectedResult = "Черная булочка";
        String actualResult = burger.bun.getName();

        Assert.assertEquals("Ожидаемый и фактический результат не совпадают",
                expectedResult, actualResult);
    }

    @Test
    public void addBurgerIngredientTest() {
        burger.addIngredient(ingredient1);

        Assert.assertThat("Ожидаемый и фактический результат не совпадают",
                burger.ingredients.get(0), is(notNullValue()));
    }

    @Test
    public void removeBurgerIngredientTest() {
        burger.ingredients.add(ingredient1);
        burger.removeIngredient(0);

        int expectedResult = 0;
        int actualResult = burger.ingredients.size();

        Assert.assertEquals("Ожидаемый и фактический результат не совпадают", expectedResult, actualResult);
    }

    @Test
    public void moveBurgerIngredientTest() {
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(0, 1);

        Assert.assertEquals("Ожидаемый и фактический результат не совпадают",
                ingredient2, burger.ingredients.get(0));
        Assert.assertEquals("Ожидаемый и фактический результат не совпадают",
                ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getBurgerPriceTest() {
        when(bun.getPrice()).thenReturn(2F);
        when(ingredient1.getPrice()).thenReturn(2F);
        when(ingredient2.getPrice()).thenReturn(2F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedResult = 2F*2 + 2F + 2F;
        float actualResult = burger.getPrice();

        Assert.assertEquals("Ожидаемый и фактический результат не совпадают",
                expectedResult, actualResult, 0.1);
    }

    @Test
    public void getBurgerReceiptTest() {
        when(bun.getName()).thenReturn("Черная булочка");
        when(ingredient1.getName()).thenReturn("Сырный");
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("Бекон");
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(bun.getPrice()).thenReturn(2F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectResult =
                "(==== Черная булочка ====)" + System.lineSeparator() +
                "= sauce Сырный =" + System.lineSeparator() +
                "= filling Бекон =" + System.lineSeparator() +
                "(==== Черная булочка ====)" + System.lineSeparator() + System.lineSeparator() +
                "Price: 4,000000" + System.lineSeparator();
        String actualResult = burger.getReceipt();

        Assert.assertEquals("Ожидаемый и фактический результат не совпадают", expectResult, actualResult);
    }
}
