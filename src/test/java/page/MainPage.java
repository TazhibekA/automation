package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage
{
    private final String BASE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@aria-label=\"Search\"]")
    WebElement inputSearch;

    @FindBy(className = "gsc-resultsbox-visible")
    WebElement visible;

    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SearchPage searchByText(String searchText)
    {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label=\"Search\"]")));
        wait.until(ExpectedConditions.elementToBeClickable(inputSearch));
        //driver.findElement(By.xpath("//input[@aria-label=\"Search\"]")).sendKeys(searchText);
        inputSearch.sendKeys(searchText);
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.elementToBeClickable(visible));
        return new SearchPage(driver);
    }

    public MainPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }
}

