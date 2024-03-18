package UnifyedX.CustomerOnboarding.ReusableComponenets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponents {
	
	WebDriver driver;

	@FindBy(xpath="//img[@alt='Unifyed Logo']") WebElement Locator_UnifyedLogo;
	@FindBy(xpath="//div[@aria-label='animation']") WebElement Locator_Animation;

	public ReusableComponents(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	//Verify page title
		public String Method_VerifyPageTitle() {
			String pageTitle = driver.getTitle();
			return pageTitle;
			/*
			 * if(pageTitle.contains("Welcome to Unifyed")) {
			 * System.out.println("Page title is showing up correctly."); }
			 */
		}
		
	//Verify unifyed logo presence
	public boolean Method_VerifyUnifyedLogo() {
		boolean logovisibility = Locator_UnifyedLogo.isDisplayed();
		return logovisibility;
		/*
		 * if (logovisibility==true) {
		 * System.out.println("Logo is showing up correctly on the page."); } else {
		 * System.out.println("Logo is not showing up on the page."); }
		 */
	}
	
	//verify if unifyed logo is clickable.
		public boolean Method_VerifyUnifyedLogoClickable() {
			boolean logoclickable = Locator_UnifyedLogo.isEnabled();
			return logoclickable;
			/*
			 * if (logoclickable==true) { System.out.println("Logo is Clickable."); } else {
			 * System.out.println("Logo is not Clickable."); }
			 */
		}
		
		//Verify if animation is showing up.
		public boolean Method_VerifyAnimation() {
			boolean animationvisibility = Locator_Animation.isDisplayed();
			return animationvisibility;
			/*
			 * if(animationvisibility==true) {
			 * System.out.println("Animation is showing up correctly."); }
			 */
		}
		
		public void Method_Hardsleep() throws InterruptedException {
			Thread.sleep(2000);
		}
		
}
