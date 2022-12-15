package st;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class team {
	WebDriver driver;
	@Given("the user is logged in")
	public void the_user_is_logged_in() {
		driver = new ChromeDriver();
        driver.get("https://classic.freecrm.com/index.html");
		WebElement password=driver.findElement(By.name("password"));
		WebElement username=driver.findElement(By.name("username"));
		username.sendKeys("BatoolDShilleh");
		password.sendKeys("1234567");
		driver.findElement(By.cssSelector("#loginForm > div > div > input")).click();
	}

	@When("I click on view team")
	public void i_click_on_view_team() {
		WebDriverWait d = new WebDriverWait(driver,java.time.Duration.ofSeconds(10));
		d.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainpanel"));
		driver.findElement(By.linkText("Team View")).click();;
		
	}

	@Then("I should be navigated the users")
	public void i_should_be_navigated_the_users() {
		String text = driver.findElement(By.cssSelector("body > table:nth-child(5) > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > table > tbody > tr:nth-child(3) > td:nth-child(1) > a")).getText();
		
		if (text == "shahd batool "){
				assertTrue(true);
		}
	}
}
