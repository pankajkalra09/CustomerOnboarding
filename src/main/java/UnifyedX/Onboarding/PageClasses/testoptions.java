package UnifyedX.Onboarding.PageClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class testoptions {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://onboarding.qa.unifyedx.com/onboard");
		String[] option = {"Increasing Quality of Applijcants","Growing Revenue from Tuition","Increasing Student Engagement","Reducing Cost of Technology","Improving Annual Graduation Rates","Decreasing Unfilled Courses and Classes"}; 
		List<WebElement> options = driver.findElements(By.xpath("//ul/li/button"));
		for (int i=0;i<options.size();i++) {
			System.out.println( options.get(i).getText().equalsIgnoreCase(option[i]));		

			//System.out.println(Stream.of(options.get(i).getText()).anyMatch(s->s.equalsIgnoreCase("Reducing Cost of Technology")));
		}
	
	}

}
