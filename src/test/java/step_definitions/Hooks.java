package step_definitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.util.HashMap;
import java.util.Map;


import static utils.TestRunner.extent;

public class Hooks {
    static ExtentTest test;
    public static WebDriver driver;
    public static String downloadfolderPath = System.getProperty("user.dir") + "\\testDataOutput";
    private ChromeOptions chromeOptions = new ChromeOptions();
    private FirefoxOptions firefoxOptions = new FirefoxOptions();

    @Before
    public void before(Scenario scenario) {
        test = extent.createTest(scenario.getName());
        String browser = System.getProperty("browser", "chromeheadless");
        switch (browser.toLowerCase().trim()) {
            case "chrome":
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("download.default_directory", downloadfolderPath);

                WebDriverManager.chromedriver().setup();
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "chromeheadless":
                HashMap<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.deafult_directory", downloadfolderPath);
                WebDriverManager.chromedriver().setup();
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                chromeOptions.addArguments("headless");
                chromeOptions.addArguments("window-size=1500,1020");
                chromeOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);

                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefoxheadless":
                firefoxOptions.addArguments("-headless");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;
        }

    }

    @After
    public void after(Scenario scenario) {
        System.out.println(scenario.getStatus() + "----" + " " + scenario.getName());
        if (scenario.getStatus().equals("pass")) {
            System.out.println("Test is passed");
        }
        if (scenario.isFailed()) {
            System.out.println(scenario.getName().toUpperCase() + " is Failed");
            try {
                scenario.log("Current Page URL is" + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());

            }

        }
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}




