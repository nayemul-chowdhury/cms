package cmspackage;



import java.util.concurrent.TimeUnit;



import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Login {
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
  public void createReq() throws Exception {
	    driver.get(baseUrl);
	    System.out.println("opening browser");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("admin");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("admin");
	    driver.findElement(By.cssSelector("button.primary")).click();
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
