package com.friday.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    protected static ExtentReports reports;

    protected static ExtentSparkReporter sparkReporter;

    protected static ExtentTest extentLogger;
    protected WebDriverWait wait;


   @BeforeTest
    public void beforeTest(){
        reports = new ExtentReports();
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        sparkReporter = new ExtentSparkReporter(path);

        reports.attachReporter(sparkReporter);

        sparkReporter.config().setReportName("Extent Report Test");

        reports.setSystemInfo("Environment", "QA");
        reports.setSystemInfo("Browser", ConfigReader.getProperties("browser"));
        reports.setSystemInfo("OS", System.getProperty("os.name"));
        reports.setSystemInfo("OS", System.getProperty("os.version"));
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browser){

        driver = Driver.getDriver(browser);
        driver.get(ConfigReader.getProperties("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));


    }

    @AfterMethod
    public void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterTest
    public void reportClose(){
       reports.flush();
    }


}
