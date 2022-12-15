package st;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class log {
	WebDriver driver;
	@Given("user in the login page")
	public void user_in_the_login_page() {
		driver = new ChromeDriver();  
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");
	}

	@When("I enter my email address and password")
	public void i_enter_my_email_address_and_password() {
		WebElement password=driver.findElement(By.name("password"));
		WebElement username=driver.findElement(By.name("username"));
		username.sendKeys("BatoolDShilleh");
		password.sendKeys("1234567");
	}

	@When("I click on submit")
	public void i_click_on_submit() {
		driver.findElement(By.cssSelector("#loginForm > div > div > input")).click();
	}

	@Then("I should be navigated to home page")
	public void i_should_be_navigated_to_home_page() {
		boolean editStatus = driver.findElement(By.cssSelector("head > title")).isEnabled();
	    assertTrue(editStatus);
		System.out.print("hi");
	}

}
