package UnifyedX.Onboarding.PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UnifyedX.Onboarding.ReusableComponenets.ReusableComponents;

public class PageClass_Step1 extends ReusableComponents{

WebDriver driver;
	
	public PageClass_Step1(WebDriver driver) {
		super(driver);// We are passing life of driver to parent class ReusableComponents as here driver is getting life from our testclass.
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[@aria-label='Pick your three most important challenges']") WebElement Locator_Question1;
	@FindBy(xpath="//button[@type='Submit']") WebElement Locator_NextCTA_step1;
	@FindBy(xpath="//p[contains(text(), 'You can only select 3 options!')]") WebElement Locator_errormessage;
	@FindBy(xpath = "//ul/li/button") List<WebElement> Locator_options;
	By optionsBy = By.xpath("//ul/li/button"); //for abstract wait we are passing by element that's why we declare it like this.
	By alertmessage = By.xpath("//p[contains(text(), 'You can only select 3 options!')]");
	
	
	//verify if question text is correct we want to see
	public void Method_VerifyQuestionTest() {
		String questiontext = Locator_Question1.getText();
		//return questiontext;
		questiontext.equalsIgnoreCase("Pick your three most important challenges?");
	}
	
	
	
	//Verify if Next CTA is disabled till the user has not selected 3 options.
	public boolean Method_VerifyNextCTA_Beforeselection() {
		boolean nextctabeforeselection = Locator_NextCTA_step1.isEnabled();
		return nextctabeforeselection;
		/*
		 * if (nextcta==false) {
		 * System.out.println("Next CTA is disabled initially without selection."); }
		 */
	}
	
	public boolean Method_VerifyNextCTA_Afterselection() {
		boolean nextctaafterselection = Locator_NextCTA_step1.isEnabled();
		return nextctaafterselection;
		/*
		 * if (nextcta==true) {
		 * System.out.println("Next CTA is Clickable after 3 selections."); }
		 */
	}
	
	
	
	//wait for the options to get loaded.
	public List<WebElement> Method_GetOptionsSteps1() {
		waitForElementToAppear(optionsBy); //wait for elements to get visible first.
		return Locator_options; //getting all the web elements as a list here.
	}
	
	public void Method_GetOptionsByName(String option1, String option2, String option3) throws InterruptedException {
		WebElement opt_1 = Locator_options.stream().filter(o->o.getText().equals(option1)).findFirst().orElse(null);
		opt_1.click();
		WebElement opt_2 = Locator_options.stream().filter(o->o.getText().equals(option2)).findFirst().orElse(null);
		opt_2.click();
		WebElement opt_3 = Locator_options.stream().filter(o->o.getText().equals(option3)).findFirst().orElse(null);
		opt_3.click();
	}
	 
	//Verify if user select 4 values and error message is showing up.
public void Method_SelectingFourthValues(String option4 ) throws Exception {
		List<WebElement> step1options = driver.findElements(By.xpath("//ul/li/button"));
		WebElement optio4 = step1options.stream().filter(o->o.getText().equals(option4)).findFirst().orElse(null);
		optio4.click();
		
	}

public String Method_VerifyErrorMessage() {
	waitForElementToAppear(alertmessage);
	String errormessage = Locator_errormessage.getText();
	return errormessage;
	/*
	 * if(errormessage.contentEquals(errormessg)) { System.out.
	 * println("Error message is showing up correctly upon selecting more than 3 values as: "
	 * +errormessage); }
	 */
	
}

public PageClass_Step2 Method_VerifyNextCTA_Click() {
	Locator_NextCTA_step1.click();
	return new PageClass_Step2(driver);
}


}
