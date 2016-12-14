

import java.io.*;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;




public class bingbing 
{
	public static void main(String [] args) throws IOException, InterruptedException
	{
		int pos, min = 0, max;
		ArrayList<String> dictionary = new ArrayList<String>();
		HashSet<String> used = new HashSet<String>();
		
		Scanner sc = new Scanner(new File("dictionary.txt"));
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		WebDriver driver = new ChromeDriver(capabilities);		
		WebElement element;
		WebElement email;
		WebElement password;		
		
		driver.get("https://www.bing.com/fd/auth"
				+ "/signin?action=interactive&provider=windows_live"
				+ "_id&return_url=http%3a%2f%2fwww.bing.com%2"
				+ "f%3fwlexpsignin%3d1%26wlexpsignin%3d1&src="
				+ "EXPLICIT&sig=25CB5B903CAF615E3563524B3D436051");
		
		Thread.sleep(1500);
		
		
		
		email = driver.findElement(By.id("i0116"));		
		
		email.sendKeys("YOUR EMAIL HERE");
		
		email = driver.findElement(By.id("idSIButton9"));
		
		email.click();
		
		Thread.sleep(1500);
		
		password = driver.findElement(By.id("i0118"));
		
		
		password.sendKeys("YOUR PASSWORD HERE");
		
		password = driver.findElement(By.id("idSIButton9"));
		
		password.click();		
		
		Thread.sleep(2000);		
		
		System.setProperty("webdriver.Chrome.driver", "LOCATION OF CHROME DRIVER HERE");
		
		while(sc.hasNext())
			dictionary.add(sc.next());
		
		max = dictionary.size() - 1;
		
		sc.close();		
		
		
		
		for(int i = 0; i < 20; i++)
		{
			element = driver.findElement(By.name("q"));
			element.clear();
			
			pos = min + (int)(Math.random() * ((max - min) + 1));
			
			if(!used.contains(dictionary.get(pos)))
			{
				element.sendKeys(dictionary.get(pos));
				element.submit();
				
				used.add(dictionary.get(pos));
				
				Thread.sleep(1000);
			}
			else
			{
				i--;
			}
		}
		
		driver.quit();		
	}

}
