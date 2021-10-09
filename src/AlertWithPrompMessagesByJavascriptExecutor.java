import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AlertWithPrompMessagesByJavascriptExecutor {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		String script= "return document.title;";
		String title= (String) js.executeScript(script);
		System.out.println(title);
		
		//Click on button
		driver.switchTo().frame("iframeResult");
		js.executeScript("myFunction()");
		
		
		Alert alert= driver.switchTo().alert();
		alert.sendKeys("Sohan");
		alert.accept();
		
		

	}

}
