package stepDefinition;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class SmokeTest  {
	
	WebDriver driver;
	
	
	

	
	
	/*@FindBy(xpath="//input[@placeholder='Username']")
	WebElement un;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement pw;
	
	@FindBy(xpath="//*[@id='loginForm']/div/div/input")
	WebElement loginbutton;*/
	
	
	
	
	
	
	
	
	
	@Given("^I open CRM homepage$")
	public void i_open_Chrome() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\cd\\chromedriver.exe");
		 driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		String baseUrl="https://classic.crmpro.com/index.html";
		
driver.navigate().to(baseUrl);
		
		Thread.sleep(2000);
		
	       TakesScreenshot ts1 = (TakesScreenshot)driver;
	       File file1 = ts1.getScreenshotAs(OutputType.FILE);
	       
	       FileUtils.copyFile(file1, new File("D:\\eclipse SS\\ElementScreenshot.png"));

		
		
		
		
		/*Screenshot screenshot = new AShot().takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("D:\\eclipse SS\\ElementScreenshot.jpg"));
		
		String str = driver.getTitle();
		
		SoftAssert a = new SoftAssert();
		System.out.println("softassert test started");
		a.assertEquals("mnop", str);
		
		
		System.out.println("soft assert ended");/*
		
		
		
		/*Thread.sleep(2000);
		System.out.println("hardassert test started");
		Assert.assertEquals("mnnm", str);
		
		System.out.println("hard assert ended")
		
		
		
		
		
		driver.get(baseUrl);*/
		
		Thread.sleep(4000);
		
		
	}

	
@When("^I enter valid \"(.*?)\" and \"(.*?)\"$")
public void i_enter_valid_and(String username, String password) throws IOException, InterruptedException {
	
	
	WebElement un = driver.findElement(By.xpath("//input[@placeholder='Username']"));
	un.click();
	un.sendKeys(username);
	
	Thread.sleep(3000);
	
	Screenshot screenshot = new AShot().takeScreenshot(driver);
	ImageIO.write(screenshot.getImage(), "jpg", new File("D:\\eclipse SS\\ElementScreenshot.jpg"));
	
	
	WebElement pw = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	pw.sendKeys(password);
	
	
}

@When("^click on login$")
public void click_on_login() {
	

	WebElement loginbutton = driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input"));
	loginbutton.click();
	
	
}


@Then("^landing page should be displayed$")
public void landing_page_should_be_displayed() {
	String title =driver.getTitle();
	driver.quit();
}
}


