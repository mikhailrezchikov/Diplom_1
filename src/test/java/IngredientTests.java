import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTests {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                {IngredientType.FILLING, "Сыр", 100.5F},
                {IngredientType.SAUCE, "Сырный", 60.0F},
                {IngredientType.FILLING, "Бекон", 50F},
        };
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type,name,price);
        IngredientType actualResult = ingredient.getType();

        Assert.assertEquals("Ожидаемый и фактический результат не совпадают", type, actualResult);
    }

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(type,name,price);
        String actualResult = ingredient.getName();

        Assert.assertEquals("Ожидаемый и фактический результат не совпадают", name, actualResult);
    }

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type,name,price);
        float actualResult = ingredient.getPrice();

        Assert.assertEquals("Ожидаемый и фактический результат не совпадают", price, actualResult, 0.1);
    }
}
