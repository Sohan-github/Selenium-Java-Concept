import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot_alertWithPrompMessages {

	public static void main(String[] args) throws IOException {

		Date currentdate = new Date();
		String screenshotfilesname = currentdate.toString().replace(" ", "-").replace(":", "-");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/" + screenshotfilesname + ".png"));

		WebElement frame1 = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("/html/body/button")).click();
		// Java Script alert
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("SOHAN");
		alert.accept();

		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile1, new File(".//W3School/" + screenshotfilesname + ".png"));

		/*
		 * WebElement message= driver.findElement(By.xpath("//*[@id='demo']"));
		 * System.out.println(message.getAttribute("demo%")); // Switching Parent Frame
		 * driver.switchTo().parentFrame(); System.out.println(driver.getTitle());
		 */
		driver.close();

	}

}
