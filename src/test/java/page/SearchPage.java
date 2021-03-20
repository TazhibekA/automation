package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends AbstractPage
{

    public SearchPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CalculatorPage chooseByText(String chosenText){
        driver.findElement(By.linkText(chosenText)).click();
        return new CalculatorPage(driver);
    }

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }

}