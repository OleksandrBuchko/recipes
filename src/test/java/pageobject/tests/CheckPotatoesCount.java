package pageobject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.pages.RecipesHomePage;
import pageobject.testbase.TestBase;

public class CheckPotatoesCount extends TestBase{
		
	@Test
	public void CheckPotatoesCountTest()  {

		RecipesHomePage recipesHomePage = new RecipesHomePage(webDriver);

		//verify number of recipes with #potato hashtag
		recipesHomePage.clickAllTab();
		recipesHomePage.inputTextToFilterField("#potato");
		int size = recipesHomePage.getRecipesOnPageAmount();

		//we have 3 recipes with #potato hashtag, so we check number of items with that value
		Assert.assertEquals(size,3,"Wrong items count.");
	}

}
