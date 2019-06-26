package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends NavigationBar{

    @FindBy(how = How.XPATH, using = "//h1[child::span[text()='Welcome, Java Hipster!']][@jhitranslate='home.title']")
    public WebElement welcomeTitle;

    @FindBy(how = How.XPATH, using = "//span[@id='home-logged-message']")
    public WebElement connexionMessage;

    // Click on Administration then User management
    public UserManagementPage goToUserManagementPage(WebDriver driver, WebDriverWait wait){
        adminMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(userManagementLink));
        userManagementLink.click();
        return PageFactory.initElements(driver, UserManagementPage.class);
    }

    // First init
    public static HomePage firstInit(WebDriver driver){
        return PageFactory.initElements(driver, HomePage.class);
    }
}
