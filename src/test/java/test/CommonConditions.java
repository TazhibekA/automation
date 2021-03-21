package test;

import driver.DriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CommonConditions {

    protected WebDriver driver;


    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser(ITestResult result) throws Exception {
        captureScreenshot(result);
        DriverSingleton.closeDriver();
    }

    private  void captureScreenshot(ITestResult result) throws Exception {
        if(result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SKIP){
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("C:\\Users\\User\\Downloads\\Automation\\src\\test\\java\\screenshots\\" + timestamp() + ".png"));
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        }
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}
