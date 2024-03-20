package UnifyedX.CustomerOnboarding.Tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import UnifyedX.CustomerOnboarding.TestComponents.BaseTestClass;
import UnifyedX.Onboarding.PageClasses.PageClass_Step1;
import UnifyedX.Onboarding.PageClasses.PageClass_Step2;
import UnifyedX.Onboarding.PageClasses.PageClass_Step3;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OnboardingStep2TEST extends BaseTestClass {

//	public PageClass_Step1 ObjectStep1;
	public PageClass_Step2 ObjectStep2;

	@Test
	public void FirstTesta() throws Exception {
		ObjectStep2 = new PageClass_Step2(driver);

		ObjectStep2.Method_VerifyPageTitle();
		Assert.assertEquals(ObjectStep2.Method_VerifyPageTitle(), prop.getProperty("PageTitle"));
		ObjectStep2.Method_VerifyUnifyedLogo();
		ObjectStep2.Method_VerifyUnifyedLogoClickable();
		ObjectStep2.Method_VerifyQuestionTest();
		Assert.assertTrue(true);
		ObjectStep2.Method_VerifyAnimation();
		Assert.assertTrue(true);
		ObjectStep2.Method_VerifyNextCTA_Beforeselection();
		Assert.assertFalse(false);
		ObjectStep2.Method_SelectingFirstValues(prop.getProperty("Step2option6"));
		ObjectStep2.Method_Hardsleep();
		ObjectStep2.Method_VerifyNextCTA_Afterselection();
		Assert.assertTrue(true);
		PageClass_Step3 ObjectStep3 = ObjectStep2.Method_VerifyNextCTA_Click();
		ObjectStep2.Method_Hardsleep();

	}
}
