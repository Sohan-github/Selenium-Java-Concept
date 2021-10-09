import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLCertificateError {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setAcceptInsecureCerts(true);
		
		ChromeOptions coption= new ChromeOptions();
		coption.merge(dc);
		
		WebDriver driver= new ChromeDriver(coption);
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	}

}
