package pageobject.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RecipesHomePage {

    WebDriver webDriver;

    @FindBy(how = How.XPATH, using = "//*[@type='text']")
    private WebElement filterField;

    @FindBy(how = How.XPATH, using = "(//*[@style = 'color: inherit;'])[1]")
    private WebElement firstNotFavouriteRecipe;

    @FindBy(how = How.XPATH, using = "//*[@class='ui text menu']/a[2]")
    private WebElement allTab;

    @FindBy(how = How.XPATH, using = "//*[@class='ui text menu']/a[3]")
    private WebElement favouritesTab;

    @FindBy(how = How.XPATH, using = "//*[@class='plus icon']")
    private WebElement plusIcon;


    @FindBy(how = How.XPATH, using = "//*[@class='ui green button']")
    private WebElement greenButton;


       public RecipesHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickPlusIcon(){
        plusIcon.click();
    }

    public boolean ifFormOpened(){
           if (greenButton.isDisplayed()) return true;
           else return false;
    }

    public void makeRecipeFavourite(){
           firstNotFavouriteRecipe.click();
    }

    public void clickGreenButton(){
        greenButton.click();
    }

    public void inputTextToFilterField(String filterText) {
        filterField.sendKeys(filterText);
    }

    public void clickAllTab() {
        allTab.click();
    }

    public void clickFavouritesTab(){
           favouritesTab.click();
    }

        public int getRecipesOnPageAmount(){
            return webDriver.findElements(By.xpath("//*[@class='ui doubling stackable three column grid']//*[@class='column']")).size();
        }

    public List<WebElement> getAllRecipesOnPage(){
        return webDriver.findElements(By.xpath("//*[@class='ui doubling stackable three column grid']//*[@class='column']"));
    }

}
