package pageobject.webdriver;import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * A factory that returns a singleton of WebDriver object.
 */
public class WebDriverFactory {

	private static final String CHROME = "chrome";
	private static final String FIREFOX = "firefox";

	private static WebDriver webDriver;

	private WebDriverFactory() {

	}

	/**
	 * Gets the single instance of WebDriverFactory.
	 *
	 * @param browserName the browser set in properties
	 * @return single instance of WebDriverFactory
	 * @throws Exception the exception of invalid browser property
	 */
	public static WebDriver getInstance(String browserName) {
		if (webDriver == null) {
			if (CHROME.equals(browserName)) {
				setChromeDriver();

				webDriver = new ChromeDriver();

			} else if (FIREFOX.equals(browserName)) {
                setFirefoxDriver();

                webDriver = new FirefoxDriver();

			} else
				webDriver = new ChromeDriver();
		}

		return webDriver;
	}

	/**
	 * Kill driver instance.
	 * @throws Exception
	 */
	public static void killDriverInstance() {
		if (webDriver != null) {
			webDriver.quit();
			webDriver = null;
		}
	}

	/**
	 * Sets the chrome driver path for specific OS.
	 *
	 * @throws Exception the exception
	 */
	private static void setChromeDriver() {
	String chromeBinary = "src/main/resources/drivers/chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", chromeBinary);
}


    private static void setFirefoxDriver() {
        String firefoxBinary = "src/main/resources/drivers/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", firefoxBinary);
    }
}