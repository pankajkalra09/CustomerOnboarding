package UnifyedX.CustomerOnboarding.Tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UnifyedX.CustomerOnboarding.TestComponents.BaseTestClass;
import UnifyedX.Onboarding.PageClasses.PageClass_Step1;
import UnifyedX.Onboarding.PageClasses.PageClass_Step2;
import UnifyedX.Onboarding.PageClasses.PageClass_Step3;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OnboardingStep1TEST extends BaseTestClass {
	@Test
	public void ReadOnlyComponents() throws Exception {
		PageClass_Step1 ObjectStep1 = new PageClass_Step1(driver);
		ObjectStep1.Method_VerifyPageTitle();
		Assert.assertEquals(ObjectStep1.Method_VerifyPageTitle(), prop.getProperty("PageTitle"));
		ObjectStep1.Method_VerifyUnifyedLogo();
		Assert.assertTrue(true);
		ObjectStep1.Method_VerifyUnifyedLogoClickable();
		Assert.assertTrue(true);
		ObjectStep1.Method_VerifyAnimation();
		Assert.assertTrue(true);
		ObjectStep1.Method_VerifyNextCTA_Beforeselection();
		Assert.assertFalse(false);
		ObjectStep1.Method_WaitGetOptionsSteps1();
		Assert.assertTrue(ObjectStep1.Method_VerifyOptionsTextStep1(prop.getProperty("Step1option1"),
		prop.getProperty("Step1option2"), prop.getProperty("Step1option3"), prop.getProperty("Step1option4"),
		prop.getProperty("Step1option5"), prop.getProperty("Step1option6")));
		ObjectStep1.Method_GetOptionsByName(prop.getProperty("Step1option1"), prop.getProperty("Step1option2"),
		prop.getProperty("Step1option3"));
		ObjectStep1.Method_VerifyNextCTA_Afterselection();
		Assert.assertTrue(true);
		ObjectStep1.Method_Hardsleep();
		ObjectStep1.Method_SelectingFourthValues(prop.getProperty("Step1option5"));
		Assert.assertEquals(ObjectStep1.Method_VerifyErrorMessage(), prop.getProperty("Step1erromsg"));
		ObjectStep1.Method_VerifyNextCTA_Click();
		// ObjectStep2=ObjectStep1.Method_VerifyNextCTA_Click();
		ObjectStep1.Method_Hardsleep();
	}
	
	
}
