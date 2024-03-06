package UnifyedX.CustomerOnboarding.PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClassStep1 {

	WebDriver driver;
	
	public ClassStep1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class=' cursor-default']/img") WebElement Locator_UnifyedLogo;
	@FindBy(xpath="//div/h1") WebElement Locator_Question1;
	@FindBy(xpath="//button[@type='Submit']") WebElement Locator_NextCTA;
	@FindBy(xpath="//div[@aria-label='animation']") WebElement Locator_Animation;
	@FindBy(xpath="//p[contains(text(), 'You can only select 3 options!')]") WebElement Locator_errormessage;
	
	//Verify page title
	public void Method_VerifyPageTitle() {
		String pageTitle = driver.getTitle();
		if(pageTitle.contains("Welcome to Unifyed")) {
			System.out.println("Page title is showing up correctly.");
		}
	}
	
	//Verify unifyed logo presence
	public void Method_VerifyUnifyedLogo() {
		boolean logovisibility = Locator_UnifyedLogo.isDisplayed();
		if (logovisibility==true) {
			System.out.println("Logo is showing up correctly on the page.");
		}
		else {
			System.out.println("Logo is not showing up on the page.");
		}
	}
	
	//verify if unifyed logo is clickable.
	public void Method_VerifyUnifyedLogoClickable() {
		boolean logoclickable = Locator_UnifyedLogo.isEnabled();
		if (logoclickable==true) {
			System.out.println("Logo is Clickable.");
		}
		else {
			System.out.println("Logo is not Clickable.");
		}
	}
	
	//verify if question text is correct we want to see
	public void Method_VerifyQuestionTest() {
		String questiontext = Locator_Question1.getText();
		questiontext.equalsIgnoreCase("Pick your three most important challenges?");
	}
	
	//Verify if animation is showing up.
	public void Method_VerifyAnimation() {
		boolean animationvisibility = Locator_Animation.isDisplayed();
		if(animationvisibility==true) {
			System.out.println("Animation is showing up correctly.");
		}
	}
	
	//Verify if Next CTA is disabled till the user has not selected 3 options.
	public void Method_VerifyNextCTA_Beforeselection() {
		boolean nextcta = Locator_NextCTA.isEnabled();
		if (nextcta==false) {
			System.out.println("Next CTA is disabled initially without selection.");
		}
	}
	
	public void Method_VerifyNextCTA_Afterselection() {
		boolean nextcta = Locator_NextCTA.isEnabled();
		if (nextcta==true) {
			System.out.println("Next CTA is Clickable after 3 selections.");
		}
	}
	
	//Verify if selecting 3 values	
	public void Method_SelectingThreeValues(String option1, String option2, String option3 ) throws Exception {
		
		List<WebElement> step1options = driver.findElements(By.xpath("//ul/li/button"));
		WebElement optio = step1options.stream().filter(o->o.getText().equals(option1)).findFirst().orElse(null);
		optio.click();
		WebElement optio1 = step1options.stream().filter(o->o.getText().equals(option2)).findFirst().orElse(null);
		optio1.click();
		WebElement optio2 = step1options.stream().filter(o->o.getText().equals(option3)).findFirst().orElse(null);
		optio2.click();
		Thread.sleep(2000);
	}
	
	//Verify if user select 4 values and error message is showing up.
public void Method_SelectingFourthValues(String option4 ) throws Exception {
		
		List<WebElement> step1options = driver.findElements(By.xpath("//ul/li/button"));
		WebElement optio3 = step1options.stream().filter(o->o.getText().equals(option4)).findFirst().orElse(null);
		optio3.click();
		Thread.sleep(2000);
		String errormessage = Locator_errormessage.getText();
		if(errormessage.contentEquals("You can only select 3 options!")) {
			System.out.println("Error message is showing up correctly upon selecting more than 3 values as: "+errormessage);
		}
		
		
	}


}
