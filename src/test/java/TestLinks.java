
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestLinks {
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
    public void testLinks() throws Exception {
        driver.get(baseUrl + "/src/main/index.html");
        driver.findElement(By.linkText("My CV")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


}
