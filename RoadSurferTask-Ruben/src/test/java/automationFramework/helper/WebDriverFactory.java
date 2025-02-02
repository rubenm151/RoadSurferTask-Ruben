package automationFramework.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverFactory  {
    private final String CHROME_DRIVER_WIN_PATH;
    private final String CHROME_DRIVER_MAC_PATH;
    private final String CHROME_DRIVER_LINUX_PATH;
    private final long IMPLICITLY_TIMEOUT;

    public WebDriverFactory() {
        CHROME_DRIVER_MAC_PATH = "/usr/local/bin/chromedriver";
        CHROME_DRIVER_WIN_PATH = "C://Selenium//chromedriver.exe";
        CHROME_DRIVER_LINUX_PATH = "/usr/bin/chromedriver";
        IMPLICITLY_TIMEOUT = 5;
    }

    public WebDriver createDriver(String browser) {
        WebDriver driver;
        String os = System.getProperty("os.name");

        if (browser.equalsIgnoreCase("chrome")) {
            String driverPath = switch (os.split(" ")[0]) {
                case "Windows" -> CHROME_DRIVER_WIN_PATH;
                case "Mac" -> CHROME_DRIVER_MAC_PATH;
                case "Linux" -> CHROME_DRIVER_LINUX_PATH;
                default -> throw new IllegalStateException("Unsupported OS: " + os);
            };

            System.setProperty("webdriver.chrome.driver", driverPath);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_TIMEOUT));
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }

}