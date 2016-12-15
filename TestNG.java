package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
public class TestNG {
	private static WebDriver driver = null;
	
	 @DataProvider
	 public String[][] loginData() {
		  return new String[][] { { "", "" },
				  				  { "111", "111" }, 
				  		           {"bak1an@redwerk.com" ,"CEzYar1U3GAtjzwIsg4W5143HGC4op"}};
	 }
  @Test(dataProvider="loginData", priority=1)
  public void  VerifyTitleWithDifferentData(String userEmail, String userPass) {
	  driver.get("http://alkimiidev-1019460547.eu-west-1.elb.amazonaws.com/");
	  String pageTitle=driver.getTitle();
	  AssertJUnit.assertEquals(pageTitle, "Alkimii");
	  WebElement element1 = driver.findElement(By.id("user_email"));
	  element1.click();
	  element1.sendKeys(userEmail);
	  WebElement element2 = driver.findElement(By.id("user_password"));
	  element2.click();
	  element2.sendKeys(userPass);
	  WebElement element3=driver.findElement(By.cssSelector("html body.alkimii-body.texture div#cl-wrapper.login-container div.middle-login div.block-flat div form#new_user.simple_form.new_user div.foot.text-center button.btn.btn-primary"));
	  element3.click();
	  Assert.assertTrue(driver.findElement(By.xpath("//html/body/div[1]/div[3]/h3")).isDisplayed());
  }
  @BeforeTest
  public void VerifyTitle1() {
	  System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
      driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
  }

}
