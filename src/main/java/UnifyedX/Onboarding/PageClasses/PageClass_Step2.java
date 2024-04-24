package UnifyedX.Onboarding.PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UnifyedX.Onboarding.ReusableComponenets.ReusableComponents;

public class PageClass_Step2 extends ReusableComponents {

	static WebDriver driver;

	@FindBy(xpath = "//div/h1")
	WebElement Locator_Question1;
	@FindBy(xpath = "//button[@aria-label='Next Screen']")
	WebElement Locator_NextCTA_step2;
	@FindBy(xpath = "//div[@aria-label='animation']")
	WebElement Locator_Animation;
	@FindBy(xpath = "//div[@class='basis-4/6']//ul/li/button")
	List<WebElement> Locator_options_Step2;
	// @FindBy(xpath="//p[contains(text(), 'You can only select 3 options!')]")
	// WebElement Locator_errormessage;

	public PageClass_Step2(WebDriver driver) {
		super(driver);// We are passing life of driver to parent class ReusableComponents as here
						// driver is getting life from our testclass.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// verify if question text is correct we want to see
	public void Method_VerifyQuestionTest() {
		String questiontext = Locator_Question1.getText();

		boolean questiontxt = questiontext.contains("What do you need");
		// return questiontext;

		if (questiontxt == true) {
			// System.out.println("Question text is showing up correctly as: "+questiontext)
			;
		} else {
			System.out.println("Question text is not correct.");
		}

	}

	public boolean Method_VerifyOptionsTextStep2(String opt1, String opt2, String opt3, String opt4, String opt5, String opt6, String opt7, String opt8, String opt9, String opt10) {
		String[] option = {opt1,opt2,opt3,opt4,opt5,opt6,opt7,opt8,opt9,opt10}; 
		//List<WebElement> options = driver.findElements(By.xpath("//ul/li/button"));
		for (int i=0;i<Locator_options_Step2.size();i++) {
			if(!Locator_options_Step2.get(i).getText().equalsIgnoreCase(option[i]))
			return false;
			//System.out.println(Stream.of(options.get(i).getText()).anyMatch(s->s.equalsIgnoreCase("Reducing Cost of Technology")));
		}
		//return optionresult;
		return true;
	}
	
	// Verify if Next CTA is disabled till the user has not selected 3 options.
	public boolean Method_VerifyNextCTA_Beforeselection() {
		boolean nextctabefore = Locator_NextCTA_step2.isEnabled();
		return nextctabefore;
		/*
		 * if (nextcta==false) {
		 * System.out.println("Next CTA is disabled initially without selection."); }
		 */
	}

	public boolean Method_VerifyNextCTA_Afterselection() {
		boolean nextctaafter = Locator_NextCTA_step2.isEnabled();
		return nextctaafter;
		/*
		 * if (nextcta==true) {
		 * System.out.println("Next CTA is Clickable after 1 selections."); }
		 */
	}

	// Verify if user select 1 values and error message is showing up.
	public void Method_SelectingFirstValues(String option5) throws Exception {

		List<WebElement> step1options = driver.findElements(By.xpath("//ul/li/button"));
		WebElement optio5 = step1options.stream().filter(o -> o.getText().equals(option5)).findFirst().orElse(null);
		optio5.click();
	}

	public PageClass_Step3 Method_VerifyNextCTA_Click() {
		Locator_NextCTA_step2.click();
		return new PageClass_Step3(driver);
	}
}
