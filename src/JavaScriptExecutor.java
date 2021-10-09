
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();
		JavascriptExecutor jscexec = (JavascriptExecutor) driver;
		// print the title
		String script = "return document.title;";
		String title = (String) jscexec.executeScript(script);
		System.out.println(title);

		// Click button
		driver.switchTo().frame("iframeResult");
		jscexec.executeScript("myFunction()"); 
		driver.switchTo().alert().accept();
		// highlighting the button //
		WebElement tryit = driver.findElement(By.xpath("/html/body/button"));
		jscexec.executeScript("arguments[0].style.border='3px solid green'", tryit);
		 //scroll
		driver.navigate().to("https://www.w3schools.com/"); //
		WebElement Certificate = driver.findElement(By.xpath("//*[@id='getdiploma']/p")); //
		jscexec.executeScript("arguments[0].scrollIntoView(true);", Certificate); //
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		driver.close();

	}

}
