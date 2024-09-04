package automation;

import annotations.Regression;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AutomationUtils;
import utilities.BaseTest;
import utilities.Logs;

public class NavigationTests extends BaseTest {

    @Test(groups = {regression, smoke})
    public void firstTest() {
        final var url = "https://www.saucedemo.com/";

        Logs.info("Navegando a %s", url);
        driver.get(url);

        AutomationUtils.sleep(2000);//espero 2 segundos

        Logs.info("Obteniendo la url actual");
        final String urlActual = driver.getCurrentUrl();
        Logs.info("Verificando que las urls sean iguales");

        Assert.assertEquals(urlActual, url);
    }

    @Test(groups = {regression, smoke})
    @Regression
    public void secondTest() {
        final var urlHero = "https://the-internet.herokuapp.com/";
        final var urlSauce = "https://www.saucedemo.com/";

        Logs.info("Navegando a %s", urlHero);
        driver.get(urlHero);

        Logs.info("Navegando a %s", urlSauce);
        driver.get(urlSauce);

        Logs.info("Volviendo a la url anterior");
        driver.navigate().back();

        Logs.info("Obteniendo la url actual");
        final String urlActual = driver.getCurrentUrl();

        Logs.info("Verificando que la url sea la inicial %s", urlActual);
        Assert.assertEquals(urlActual, urlHero);
    }

    @Test(groups = {regression, smoke})
    @Regression
    public void thirdTest() {
        final var urlHero = "https://the-internet.herokuapp.com/";
        Logs.info("Navegando a %s", urlHero);
        driver.get(urlHero);

        Logs.info("Obteniendo la url actual");
        final String urlActual = driver.getCurrentUrl();

        Logs.info("verificando las url");
        Assert.assertEquals(urlActual, "Hola mundo"); //Siempre va a fallar para realizar una screenshot desde el FileManager.
    }


}
