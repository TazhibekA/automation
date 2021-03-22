package page;

import service.CalculatorAppInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalculatorPage extends  AbstractPage {

    @FindBy(xpath = "//input[@ng-model = \"listingCtrl.computeServer.quantity\"]")
    WebElement quantity;

    @FindBy(xpath = "//md-select[@ng-model = \"listingCtrl.computeServer.series\"]")
    WebElement series;

    @FindBy(xpath = "//*[@id=\"select_container_91\"]//md-option/div[1]")
    List<WebElement> seriesOptions;

    @FindBy(xpath = "//md-select[@ng-model=\"listingCtrl.computeServer.instance\"]")
    WebElement instance;

    @FindBy(xpath = "//*[@id=\"select_container_93\"]//md-option/div[1]")
    List<WebElement> instanceOptions;

    @FindBy(xpath = "//md-checkbox[@ng-model=\"listingCtrl.computeServer.addGPUs\"]")
    WebElement addGpus;

    @FindBy(xpath = "//md-select[@ng-model=\"listingCtrl.computeServer.gpuType\"]")
    WebElement gpuType;

    @FindBy(xpath = "//*[@id=\"select_container_399\"]//md-option/div[1]")
    List<WebElement> gpuTypeOptions;

    @FindBy(xpath = "//md-select[@ng-model=\"listingCtrl.computeServer.gpuCount\"]")
    WebElement gpuCount;

    @FindBy(xpath = "//*[@id=\"select_container_397\"]//md-option/div[1]")
    List<WebElement> gpuCountOptions;

    @FindBy(xpath = "//*[@ng-model=\"listingCtrl.computeServer.ssd\"]")
    WebElement ssd;

    @FindBy(xpath = "//*[@id=\"select_container_358\"]//md-option/div[1]")
    List<WebElement> ssdOptions;

    @FindBy(xpath = "//*[@ng-model=\"listingCtrl.computeServer.location\"]")
    WebElement location;

    @FindBy(xpath = "//*[@id=\"select_container_95\"]//md-option/div[1]")
    List<WebElement> locationOptions;

    @FindBy(xpath = "//md-select[@ng-model=\"listingCtrl.computeServer.cud\"]")
    WebElement cud;

    @FindBy(xpath = "//*[@id=\"select_container_102\"]//md-option/div[1]")
    List<WebElement> cudOptions;

    @FindBy(xpath = "//*[@ng-click=\"listingCtrl.addComputeServer(ComputeEngineForm);\"]")
    WebElement btn;

    @FindBy(id = "compute")
    WebElement compute;

    @FindBy(id = "email_quote")
    WebElement btnEmail;

    @FindBy(xpath = "//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/h2/b")
    WebElement  totalCost;

    @FindBy(xpath = "//button[@aria-label=\"Send Email\"]")
    WebElement btnSendEmail;

    @FindBy(xpath = "//*[@ng-model=\"emailQuote.user.email\"]")
    WebElement inputEmail;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public CalculatorPage fillOutComputeEngine() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(quantity));
        quantity.sendKeys(CalculatorAppInfo.getQuantity());

        series.click();
        wait.until(ExpectedConditions.elementToBeClickable(seriesOptions.get(0)));
        chooseByText(seriesOptions, CalculatorAppInfo.getseries());

        instance.click();
        wait.until(ExpectedConditions.elementToBeClickable(instanceOptions.get(0)));
        chooseByText(instanceOptions, CalculatorAppInfo.getInstance());

        wait.until(ExpectedConditions.elementToBeClickable(addGpus));
        addGpus.click();

        wait.until(ExpectedConditions.elementToBeClickable(gpuType));
        gpuType.click();

        wait.until(ExpectedConditions.elementToBeClickable(gpuTypeOptions.get(0)));
        chooseByText(gpuTypeOptions, CalculatorAppInfo.getGpuType());

        wait.until(ExpectedConditions.elementToBeClickable(gpuCount));
        gpuCount.click();

        wait.until(ExpectedConditions.elementToBeClickable(gpuCountOptions.get(0)));
        chooseByText(gpuCountOptions, CalculatorAppInfo.getGpuCount());

        wait.until(ExpectedConditions.elementToBeClickable(ssd));
        ssd.click();

        wait.until(ExpectedConditions.elementToBeClickable(ssdOptions.get(0)));
        chooseByText(ssdOptions, CalculatorAppInfo.getSsd());

        wait.until(ExpectedConditions.elementToBeClickable(location));
        location.click();

        wait.until(ExpectedConditions.elementToBeClickable(locationOptions.get(0)));
        chooseByText(locationOptions, CalculatorAppInfo.getLocation());

        wait.until(ExpectedConditions.elementToBeClickable(cud));
        cud.click();

        wait.until(ExpectedConditions.elementToBeClickable(cudOptions.get(0)));
        chooseByText(cudOptions, CalculatorAppInfo.getCud());

        wait.until(ExpectedConditions.elementToBeClickable(btn));
        btn.click();

        wait.until(ExpectedConditions.elementToBeClickable(compute));
        return this;
    }

    public CalculatorPage switchToFrameByName(String name) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id=\"myFrame\"]")));
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        for (WebElement element : elements) {
            if (element.getAttribute("id") == name) {
                driver.switchTo().frame(element);
            }
        }
        return this;
    }

    public void chooseByText(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
            }
        }
    }

    public CalculatorPage clickEmail(){
        wait.until(ExpectedConditions.elementToBeClickable(btnEmail));
        btnEmail.click();
        return this;
    }

    public CalculatorPage clickSendEmail(){
        wait.until(ExpectedConditions.elementToBeClickable(btnSendEmail));
        btnSendEmail.click();
        return this;
    }

    public String getTotalCost(){
        return totalCost.getText();

    }

    public CalculatorPage sendByAddress(String mailAddress){
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
        inputEmail.click();
        System.out.println("++++++" + mailAddress);

        inputEmail.sendKeys(mailAddress);
        clickSendEmail();
        return this;
    }


}