package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This method contains reusable methods to perform all web driver actions
 * @author krina
 *
 */

public class WebDriverUtility
{
  WebDriver driver;
  
  /**
   * This method is used to launch browser and navigate to application
   * @param browser
   * @param url
   * @param time
   * @return
   */
  public WebDriver openApplication(String browser,String url,long time)
  {
	  switch(browser)
	  {
	  case "chrome": driver= new ChromeDriver(); break;
	  case "firefox": driver= new FirefoxDriver(); break;
	  case "edge": driver= new EdgeDriver(); break;
	  default: System.out.println("Invalid browser information");break;
	  }
	  
	  driver.manage().window().maximize();
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	  return driver;
  }
  
  public void explicitWait(WebElement element, long time) 
  {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
	  wait.until(ExpectedConditions.visibilityOf(element));
  }
  /**
   * This  method is used to mouse hover on certain element
   * @param element
   */
  
  public void mouseHover(WebElement element)
  {
	  Actions a = new Actions(driver);
	  a.moveToElement(element).perform();
  }
  
  /**
   * this method is used to double click on particular element
   * @param element
   */
  
  public void doubleClickOnElement(WebElement element) 
  {
	  Actions a = new Actions(driver);
	  a.doubleClick(element).perform();
  }
  /**
   * This method is used to drag abd drop an element to required location
   * @param source
   * @param target
   */
  
  public void dragAndDropElement(WebElement source, WebElement target) 
  {
	  Actions a = new Actions(driver);
	  a.dragAndDrop(source,target).perform();
  }
  
  public void dropdown(WebElement element, int index)
  {
	  Select s= new Select(element);
	  s.selectByIndex(index);
  }
  
  public void dropdown(WebElement element, String value)
  {
	  Select s= new Select(element);
	  s.selectByValue(value);
  }
  
  public void handleChildBrowser()
  {
	  Set<String> windows=driver.getWindowHandles();
	  for(String id: windows)
	  {
		  driver.switchTo().window(id);
	  }
  }
  
  public void switchToFrame(int index)
  {
	  driver.switchTo().frame(index);
  }
  
  public void switchBackFromFrame()
  {
	  driver.switchTo().defaultContent();
  }
  
  public void handleAlert()
  {
	  driver.switchTo().alert().accept();
  }
  
  public void scrollTillElement(WebElement element)
  {
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView(true)", element);
  }
  
 
  public void screenshot()
  {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File src=ts.getScreenshotAs(OutputType.FILE);
	  File dest = new File("./Screenshot/"+driver.getTitle()+".png");
	  try {
		  FileUtils.copyFile(src, dest);
	  }catch(IOException e) {
		  e.printStackTrace();
	  }
  }
  /**
   * This method is used to close current window
   */
  public void  closeCurrentWindow()
  {
	  driver.close();
  }
  /**
   * This method is used to close  all the windows and exit the browser
   */
  public void quitBrowser()
  {
	  driver.quit();
  }
  
  
}
