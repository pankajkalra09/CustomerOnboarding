package UnifyedX.CustomerOnboarding;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import UnifyedX.CustomerOnboarding.PageClasses.PageClass_Step1;
import UnifyedX.CustomerOnboarding.PageClasses.PageClass_Step2;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOnboardingStep1 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://onboarding.qa.unifyedx.com/onboard");	
		
		PageClass_Step1 ObjectStep1 = new PageClass_Step1(driver);
		ObjectStep1.Method_VerifyPageTitle();
		String PageTitle = "Welcome to Unifyed";
		Assert.assertEquals(ObjectStep1.Method_VerifyPageTitle(), PageTitle);
		ObjectStep1.Method_VerifyUnifyedLogo();
		Assert.assertTrue(true);
		ObjectStep1.Method_VerifyUnifyedLogoClickable();
		Assert.assertTrue(true);
		ObjectStep1.Method_VerifyQuestionTest();
		ObjectStep1.Method_VerifyAnimation();
		Assert.assertTrue(true);
		ObjectStep1.Method_VerifyNextCTA_Beforeselection();
		Assert.assertFalse(false);
		ObjectStep1.Method_GetOptionsSteps1();
		String option1 = "Improving Annual Graduation Rates";
		String option2 = "Increasing Quality of Applicants";
		String option3 = "Growing Revenue from Tuition";
		String option4 = "Increasing Student Engagement";
		String erromsg = "You can only select 3 options!";
		ObjectStep1.Method_GetOptionsByName(option1, option2, option3);
		ObjectStep1.Method_VerifyNextCTA_Afterselection();
		Assert.assertTrue(true);
		ObjectStep1.Method_Hardsleep();
		ObjectStep1.Method_SelectingFourthValues(option4);
		Assert.assertEquals(ObjectStep1.Method_VerifyErrorMessage(), erromsg);
		ObjectStep1.Method_VerifyNextCTA_Click();
		ObjectStep1.Method_Hardsleep();
		
		///////////////////////////////////////////////////////////////////
		
		PageClass_Step2 ObjectStep2 = new PageClass_Step2(driver);
		ObjectStep2.Method_VerifyPageTitle();
		Assert.assertEquals(ObjectStep1.Method_VerifyPageTitle(), PageTitle);
		ObjectStep2.Method_VerifyUnifyedLogo();
		ObjectStep2.Method_VerifyUnifyedLogoClickable();
		ObjectStep2.Method_VerifyQuestionTest();
		Assert.assertTrue(true);
		ObjectStep2.Method_VerifyAnimation();
		Assert.assertTrue(true);
		ObjectStep2.Method_VerifyNextCTA_Beforeselection();
		Assert.assertFalse(false);
		String option5 = "User Friendly Experience";
		ObjectStep2.Method_SelectingFirstValues(option5);
		ObjectStep2.Method_VerifyNextCTA_Afterselection();
		Assert.assertTrue(true);
		ObjectStep2.Method_VerifyNextCTA_Click();
		ObjectStep2.Method_Hardsleep();
		driver.quit();
	}

}

