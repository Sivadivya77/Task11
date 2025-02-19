package task11;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task11q1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/windows");
	    
        driver.manage().window().maximize();
        
        WebElement name=  driver.findElement(By.xpath("//a[text()='Click Here']"));
       name.click();
        name.getText();
        //  Get window handles and switch to new window
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        System.out.println("New window prasent:" +name);
         WebElement newwindow= driver.findElement(By.tagName("h3"));
       System.out.println( newwindow.getText());
         if (newwindow.getText().equals("New Window")) {
        	  System.out.println("Tast pass'New Window'taxt is displyed");
          }
          else {
        	  System.out.println("Tast faild :Expected text not found");
        
          }
   
    
    driver.close();
      
    
    //  Switch back to original window
    driver.switchTo().window(mainWindowHandle);

    // Verify we are back to the main window
    if (driver.getTitle().equals("The Internet")) {
        System.out.println("Successfully switched back to the original window.");
    }

    // Close the browser
    driver.quit(); 
        
		

	}

}

/*OUTPUT
New window prasent:[[ChromeDriver: chrome on windows (fde8b01ece1cef086fabf7865ff08c4c)] -> xpath: //a[text()='Click Here']]
New Window
Tast pass'New Window'taxt is displyed
Successfully switched back to the original window.*/
