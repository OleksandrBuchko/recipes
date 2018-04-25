package pageobject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.pages.RecipesHomePage;
import pageobject.testbase.TestBase;

public class VerifyFavouritesOption extends TestBase {

    @Test
    public void VerifyFavouritesOptionTest() {

        RecipesHomePage recipesHomePage = new RecipesHomePage(webDriver);

        //get count of recipes in favourites tab
        recipesHomePage.clickFavouritesTab();
        int favouritesRecipesCount = recipesHomePage.getRecipesOnPageAmount();

        recipesHomePage.clickAllTab();

        //set one more recipe as favourite
        recipesHomePage.makeRecipeFavourite();

        //get count of recipes in favourites tab after adding one more recipe
        recipesHomePage.clickFavouritesTab();
        int favouritesRecipeCountUpdated = recipesHomePage.getRecipesOnPageAmount();

        //verify if count is changed by one
        Assert.assertEquals(favouritesRecipesCount + 1, favouritesRecipeCountUpdated, "Recipe is not moved to favourites");


    }

}
