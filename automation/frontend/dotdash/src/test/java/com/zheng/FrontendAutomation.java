package com.zheng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Shimei Zheng
 */

public class FrontendAutomation {

	private WebDriver driver;

	/**
	 * @throws Exception
	 */
	@BeforeMethod
	public void setUp(Method method) throws Exception {

		driver = new FirefoxDriver();
		driver.get("http://localhost:8081/index.php");

	}

	@Test(priority = 0)
	public void TC_NSS_TODO_001() throws Exception {

		driver.findElement(By.xpath("//input[@name='data']")).sendKeys("buy flowers");
		Select dropDown_Category = new Select(driver.findElement(By.xpath("/html/body/div[4]/span/select[1]")));
		dropDown_Category.selectByVisibleText("Personal");

		Select dropDown_date = new Select(driver.findElement(By.xpath("/html/body/div[4]/span/select[2]")));
		dropDown_date.selectByVisibleText("1");

		Select dropDown_month = new Select(driver.findElement(By.xpath("/html/body/div[4]/span/select[3]")));
		dropDown_month.selectByVisibleText("Jul");

		Select dropDown_year = new Select(driver.findElement(By.xpath("/html/body/div[4]/span/select[4]")));
		dropDown_year.selectByVisibleText("2018");

		driver.findElement(By.xpath("/html/body/div[4]/input[2]")).click();
		String expected = "buy flowers";
		String actual = driver.findElement(By.xpath("//*[contains(text(), 'buy flowers')]")).getText();

		assertEquals(actual, expected, "Not found the just added item");

	}

	@Test(priority = 1)
	public void TC_NSS_TODO_002() throws Exception {

		driver.findElement(By.xpath("/html/body/div[4]/span/input[1]")).sendKeys("Work");
		Select dropDown_color = new Select(driver.findElement(By.xpath("/html/body/div[4]/span/select[5]")));
		dropDown_color.selectByVisibleText("Blue");
		driver.findElement(By.xpath("/html/body/div[4]/span/input[2]")).click();
		String expected1 = "Work";
		String actual1 = driver.findElement(By.xpath("//*[contains(text(), 'Work')]")).getText();
		assertEquals(actual1, expected1, "The content is not as expected");

		String color = "rgb(0, 0, 255)";
		String actual_col = driver.findElement(By.xpath("//*[contains(text(), 'Work')]")).getCssValue("color");
		assertEquals(color, actual_col, "The color is not as expected");
	}

	@Test(priority = 2)
	public void TC_NSS_TODO_003() throws Exception {

		WebElement ele = driver
				.findElement(By.xpath("//li/span[contains(text(), 'buy flowers')]/preceding-sibling::input"));

		assertNotNull(ele);

		ele.click();

		clickCompleteButton();

		WebElement actual = driver.findElement(By.xpath("//strike[contains(text(), 'buy flowers')]"));

		assertEquals(actual.isDisplayed(), true);

		WebElement ele2 = driver
				.findElement(By.xpath("//li/span/strike[contains(text(), 'buy flowers')]/../preceding-sibling::input"));
		ele2.click();
		clickRemoveButton();

		List<WebElement> list = driver
				.findElements((By.xpath("//strike[contains(text(), 'buy flowers')]/preceding-sibling::input")));

		assertTrue(list.isEmpty(), "the element was not removed");

	}

	private void clickCompleteButton() {
		driver.findElement(By.xpath("/html/body/div[3]/input[2]")).click();
	}

	private void clickRemoveButton() {
		driver.findElement(By.xpath("/html/body/div[3]/input[1]")).click();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();

	}
}
