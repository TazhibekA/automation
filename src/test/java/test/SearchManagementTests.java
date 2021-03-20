package test;

import page.CalculatorPage;
import page.MainPage;
import page.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SearchManagementTests extends CommonConditions {
    @Test
    public void canSearch(){
        SearchPage searchPage = new MainPage(driver)
                .openPage()
                .searchByText("Google Cloud Platform Pricing Calculator");

        Assert.assertTrue(searchPage.getUrl().equals("https://cloud.google.com/s/results?q=Google%20Cloud%20Platform%20Pricing%20Calculator"));
    }

    @Test
    public void canChooseInSearchList(){
        CalculatorPage calculatorPage = new MainPage(driver)
                .openPage()
                .searchByText("Google Cloud Platform Pricing Calculator")
                .chooseByText("Google Cloud Platform Pricing Calculator");

        Assert.assertTrue(calculatorPage.getUrl().equals("https://cloud.google.com/products/calculator"));
    }


}
