package utilities;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners(value = {SuiteListeners.class, TestListeners.class})
public class BaseTest {
    protected SoftAssert softAssert;
    protected final String regression = "regression";
    protected final String smoke = "smoke";
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {
        softAssert = new SoftAssert();

        //Inicialización de Driver
        Logs.debug("Init driver");
        driver = new ChromeDriver();
        /* Inicialización de otros Drivers:
         *   -   Edge -> new EdgeDriver;
         *   -   Firefox -> new FirefoxDriver
         *   -   Safari -> new SafariDriver
         * */

        //Maximizamos la pantalla
        Logs.debug("Maximizing Window");
        driver.manage().window();

        //Borramos las cookies
        Logs.debug("Cleaning cookies");
        driver.manage().deleteAllCookies();

        new WebDriverProvider().set(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void masterTearDown() {

        //Matamos el Driver
        Logs.debug("Killing driver");
        driver.quit();
    }
}
