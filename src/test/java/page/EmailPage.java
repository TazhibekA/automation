package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailPage extends AbstractPage{
    private final String BASE_URL = "https://10minutemail.com/";

    @FindBy(id = "mail_address")
    WebElement mailAddress;

    @FindBy(id = "inbox_count_number")
    WebElement inboxCountNumber;

    @FindBy(xpath = "//*[@id=\"mail_messages_content\"]/div/div[1]/div[2]")
    WebElement mailMessageContent;

    @FindBy(id = "mobilepadding")
    WebElement mobilePadding;

    @FindBy(xpath="//*[@id=\"mobilepadding\"]/td/table/tbody/tr[2]/td[2]/h3")
    WebElement totalCost;

    public EmailPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public String getEmail(){
        wait.until(ExpectedConditions.elementToBeClickable(mailAddress));
        return mailAddress.getAttribute("value");
    }

    public String getCostFromSentMail(){
        wait.until(ExpectedConditions.textToBePresentInElement(inboxCountNumber,"1"));
        mailMessageContent.click();
        wait.until(ExpectedConditions.elementToBeClickable(mobilePadding));
        return totalCost.getText();
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

