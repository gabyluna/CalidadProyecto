

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestElementsQualities {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        Logger.getLogger("").setLevel(Level.SEVERE);
        driver = new HtmlUnitDriver();
        baseUrl = String.valueOf(System.getProperty("baseURL"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testElementsQualities() throws Exception {
        driver.get(baseUrl + "/src/main/index.html");
        driver.findElement(By.xpath("(//a[contains(text(),'Go')])[2]")).click();

        try {
            assertTrue(isElementPresent(By.cssSelector("ul.features > img")));

        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Rápido aprendizaje", driver.findElement(By.cssSelector("li")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }


        try {
            assertTrue(isElementPresent(By.cssSelector("h2.title")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Qualities", driver.getTitle());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
