import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTests {
    @Test
    public void getBunNameTest() {
        Bun bun = new Bun("Черная булочка", 2.5F);

        String expectedResult = "Черная булочка";
        String actualResult = bun.getName();

        Assert.assertEquals("Ожидаемый и фактический результат не совпадают",expectedResult, actualResult);
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun("Белая булочка", 2.5F);

        float expectedResult = 2.5F;
        float actualResult = bun.getPrice();

        Assert.assertEquals("Ожидаемый и фактический результат не совпадают",
                expectedResult, actualResult, 0.01);
    }
}
