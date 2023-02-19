package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreJavaDemoVideoPage
{
    //Declaration
	
	@FindBy(xpath="//h1[text()='Core Java For Selenium Trainin']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//button[@aria-label='Play']")
	private WebElement playButton;
	
	@FindBy(xpath="//button[@aria-label='Pause']")
	private WebElement pauseButton;
	
	@FindBy(xpath="//span[text()='Add To Wishlist']")
	private WebElement addToWishlistButton;
	
	//Initialization
	
	public CoreJavaDemoVideoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public WebElement getPageheader()
	{
		return pageHeader;
	}
	
	public void clickPlayButton()
	{
		playButton.click();
	}
	
	public void clickPauseButton()
	{
		pauseButton.click();
	}
	
	public void clickAddToWishList()
	{
		addToWishlistButton.click();
	}
}
