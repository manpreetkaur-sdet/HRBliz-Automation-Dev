package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"step_definitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    public static ExtentReports extent;

    @BeforeSuite
    public void setupExtentReports() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/report/HRB.html");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("HR Blizz UI Automation Result");
        spark.config().setReportName("Test Execution Report");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void tearDownExtentReports() {
        if (extent != null) {
            extent.flush();
        }
    }

}