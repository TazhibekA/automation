package test;

import page.CalculatorPage;
import page.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManagementTest extends CommonConditions{

    @BeforeMethod
    public void canFillOut() throws InterruptedException {
        CalculatorPage calculatorPage = new MainPage(driver)
                .openPage()
                .searchByText("Google Cloud Platform Pricing Calculator")
                .chooseByText("Google Cloud Platform Pricing Calculator")
                .switchToFrameByName("myFrame")
                .fillOutComputeEngine();
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
}
