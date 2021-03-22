package test;

import org.openqa.selenium.JavascriptExecutor;
import page.CalculatorPage;
import page.EmailPage;
import page.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ManagementTest extends CommonConditions{
    CalculatorPage calculatorPage;
    EmailPage emailPage;
    ArrayList<String> tabs;

    @BeforeMethod
    public void canFillOut() throws InterruptedException {
        calculatorPage = new MainPage(driver)
                .openPage()
                .searchByText("Google Cloud Platform Pricing Calculator")
                .chooseByText("Google Cloud Platform Pricing Calculator")
                .switchToFrameByName("myFrame")
                .fillOutComputeEngine();
    }

    @Test
    public void mailHasSent() throws InterruptedException {
        String totalCostInGoogle = calculatorPage.getTotalCost();
        calculatorPage.clickEmail();
        openNewWindow();
        Thread.sleep(3000);
        tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        emailPage = new EmailPage(driver);
        String mailaddress = emailPage
                .openPage()
                .getEmail();

        driver.switchTo().window(tabs.get(0));
        calculatorPage.switchToFrameByName("myFrame").sendByAddress(mailaddress);
        driver.switchTo().window(tabs.get(1));

        String totalCost = emailPage.getCostFromSentMail();

        Assert.assertTrue(totalCostInGoogle.contains(totalCost));
    }

    @Test
    public void checkVMClass(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[2]/div")).getText().contains("VM class: regular1"));
    }

    @Test
    public void checkInstanceType(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[3]/div")).getText().contains("Instance type: n1-standard-8"));
    }

    @Test
    public void checkRegion(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[4]/div")).getText().contains("Region: Frankfurt"));
    }

    @Test
    public void checkCommitmentTerm(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[6]/div")).getText().contains("Commitment term: 1 Year"));
    }

    public void openNewWindow(){
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }
}
