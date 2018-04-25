package pageobject.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pageobject.pages.RecipesHomePage;
import pageobject.testbase.TestBase;

public class ValidationOfAddRecipeFormFields extends TestBase {

    @Test
    public void ValidationOfAddRecipeFormFieldsTest() {

        RecipesHomePage recipesHomePage = new RecipesHomePage(webDriver);

        //validate if user is not able to create recipe when mandatory field is not filled
        recipesHomePage.clickPlusIcon();
        recipesHomePage.clickGreenButton();


        // if form is still opened that means that recipe is not created and validation rules for mandatory fields work fine
        Assert.assertTrue(recipesHomePage.ifFormOpened());
    }

}
