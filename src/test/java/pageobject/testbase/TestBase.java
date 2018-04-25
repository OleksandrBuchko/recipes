package pageobject.testbase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageobject.pages.RecipesHomePage;
import pageobject.webdriver.WebDriverFactory;

public class TestBase {

	protected WebDriver webDriver;
	protected RecipesHomePage recipesHomePage;


	@BeforeMethod
	@Parameters({ "browserName" })
	public void setup(String browserName) throws Exception {
		webDriver = WebDriverFactory.getInstance(browserName);
		webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		webDriver.get("https://volodymyr-kushnir.github.io/recipes/#/");
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() throws Exception {
		if (webDriver != null) {
			WebDriverFactory.killDriverInstance();
		}
	}

}