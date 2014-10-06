package cmspackage;



//comment again 
import java.util.concurrent.TimeUnit;




import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class CreateRequest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://162.209.110.17:5502/content/hstablet/dashboard.html";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

 
  @Test
  public void createLogin() throws Exception {
	    driver.get(baseUrl);
	    System.out.println("opening browser");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("admin");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("admin");
	    driver.findElement(By.cssSelector("button.primary")).click();
	  }
 @Test 
  public void createReq() throws Exception {
	  driver.get(baseUrl + "/libs/granite/core/content/login.html?resource=%2Fcontent%2Fhstablet%2Fdashboard.html&$$login$$=%24%24login%24%24");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("admin");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("admin");
	    driver.findElement(By.cssSelector("button.primary")).click();
	    driver.findElement(By.linkText("New Request")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
	    driver.findElement(By.name("title")).clear();
	    driver.findElement(By.name("title")).sendKeys("my first request");
	    driver.findElement(By.name("details")).clear();
	    driver.findElement(By.name("details")).sendKeys("details");
	    new Select(driver.findElement(By.id("assignee"))).selectByVisibleText("hstablet-authors");
	    driver.findElement(By.name("golive_date")).click();
	    driver.findElement(By.linkText("24")).click();
	    driver.findElement(By.id("type")).click();
	    new Select(driver.findElement(By.id("type"))).selectByVisibleText("Hotfix");
	    driver.findElement(By.linkText("Save and Add Tasks")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
	  
	  }


  @AfterTest
  public void tearDown() throws Exception {
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}

