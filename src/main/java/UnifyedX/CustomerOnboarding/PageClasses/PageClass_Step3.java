package UnifyedX.CustomerOnboarding.PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UnifyedX.CustomerOnboarding.ReusableComponenets.ReusableComponents;

public class PageClass_Step3 extends ReusableComponents{

	WebDriver driver;
	
	public PageClass_Step3(WebDriver driver) {
		super(driver);// We are passing life of driver to parent class ReusableComponents as here driver is getting life from our testclass.
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
