package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage extends NavigationBar {

    @FindBy(how = How.XPATH, using = "//span[@id='user-management-page-heading']")
    public WebElement userManagementTitle;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'jh-create-entity')][descendant::span[text()='Create a new user']][ancestor::jac-user-mgmt]")
    private WebElement newUserButton;

    /* Click on the Create New User button
    *  Args :
    *  - WebDriver driver
    *  Return :
    *  - NewUserPage
    */
    public NewUserPage goToNewUserPage(WebDriver driver){
        newUserButton.click();
        return PageFactory.initElements(driver, NewUserPage.class);
    }


}
