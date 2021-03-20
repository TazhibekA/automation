package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailPage extends AbstractPage{
    private final String BASE_URL = "https://10minutemail.com/";

    public EmailPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getEmail(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mail_address")));
        return driver.findElement(By.id("mail_address")).getText();
    }

    public EmailPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }
}

