package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public abstract class NavigationBar {

    @FindBy(how = How.XPATH, using = "//a[@id='account-menu']")
    protected WebElement accountMenu;

    @FindBy(how = How.XPATH, using = "//a[@id='login']")
    protected WebElement signInLink;

    @FindBy(how = How.XPATH, using = "//input[@id='username']")
    protected WebElement usernameInput;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    protected WebElement passwordInput;

    @FindBy(how = How.XPATH, using = "//button[@type='submit'][child::span[text()='Sign in']]")
    protected WebElement signInButton;

    @FindBy(how = How.XPATH, using = "//a[@id='admin-menu']")
    protected WebElement adminMenu;

    @FindBy(how = How.XPATH, using = "//a[@href='#/admin/user-management'][descendant::span[text()='User management']]")
    protected WebElement userManagementLink;

    @FindBy(how = How.XPATH, using = "//a[@id='logout']")
    protected WebElement signOutLink;

    /* Open the sign inFill the sign in form and submit
     * Args :
     * - String username : username to use in the form
     * - String password : password to use in the form
     * - Class<T> class_page : page to be returned
     * Return :
     * - NavigationBar : Next page
     */
    public <T extends NavigationBar> T logIn(WebDriver driver, String username, String password, Class<T> class_page) {
        //public void logIn(WebDriver driver, String username, String password) {
        accountMenu.click();
        signInLink.click();
        clearAndFillInput(usernameInput, username);
        clearAndFillInput(passwordInput, password);
        signInButton.click();
        return PageFactory.initElements(driver, class_page);
    }

    /* Clear and fill the WebElement with the value
     * Args :
     * - WebElement element : Input to fill
     * - String value : Value to put in the input
     */
    public void clearAndFillInput(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
}