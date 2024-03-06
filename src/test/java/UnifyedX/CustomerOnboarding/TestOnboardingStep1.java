package UnifyedX.CustomerOnboarding;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import UnifyedX.CustomerOnboarding.PageClasses.ClassStep1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOnboardingStep1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://onboarding.qa.unifyedx.com/onboard");
		Thread.sleep(2000);
		
		ClassStep1 ObjectStep1 = new ClassStep1(driver);
		ObjectStep1.Method_VerifyPageTitle();
		ObjectStep1.Method_VerifyUnifyedLogo();
		ObjectStep1.Method_VerifyUnifyedLogoClickable();
		ObjectStep1.Method_VerifyQuestionTest();
		ObjectStep1.Method_VerifyAnimation();
		ObjectStep1.Method_VerifyNextCTA_Beforeselection();
		String option1 = "Improving Annual Graduation Rates";
		String option2 = "Increasing Quality of Applicants";
		String option3 = "Growing Revenue from Tuition";
		String option4 = "Increasing Student Engagement";
		ObjectStep1.Method_SelectingThreeValues(option1, option2, option3);
		ObjectStep1.Method_VerifyNextCTA_Afterselection();
		ObjectStep1.Method_SelectingFourthValues(option4);
		
		
	
		
		
		/*
		 * if(driver.findElement(By.xpath("//a[@class=' cursor-default']/img")).
		 * isEnabled()) {
		 * //driver.findElement(By.xpath("//a[@class=' cursor-default']/img")).click();
		 * System.out.println("logo is showing up"); }
		 */
		 
		
		//System.out.println("title of the question is: "+driver.findElement(By.xpath("//div/h1")).getText());
		//System.out.println("Next CTA initially enabled: "+driver.findElement(By.xpath("//button[@type='Submit']")).isEnabled());		
		
		
		//System.out.println(driver.findElement(By.xpath("//button[@type='Submit']")).isEnabled());
		
		//driver.findElement(By.xpath("//button[@type='Submit']")).click();
		Thread.sleep(2000);
		
		driver.quit();
	}

}

