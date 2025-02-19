package task11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task11g2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/nested_frames");
	    
        driver.manage().window().maximize();
        
       String pagetitle= driver.getTitle();
       if(pagetitle.contains("Frame")) {
    	   System.out.println("Verified: Page title contains 'Frame'.");
       } else {
           System.out.println("Verification Failed: Page title does not contain 'Frame'.");
       }
       
       
       // Switch to the top frame using XPath
        driver.switchTo().frame("frame-top");
        // Verify three frames exist inside top frame
        if (driver.findElements(By.tagName("frame")).size() == 3) {
            System.out.println("Verified: Top frame contains three frames.");
        } else {
            System.out.println("Verification Failed: Incorrect number of frames in top frame.");
        }
     // Switch to left frame and verify text "LEFT"
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-left']")));
        WebElement leftFrameBody = driver.findElement(By.xpath("//body"));
        String leftText = leftFrameBody.getText().trim();
        if (leftText.equals("LEFT")) {
            System.out.println("Verified: LEFT frame contains correct text.");
        } else {
            System.out.println("Verification Failed: LEFT frame text mismatch.");
        }
        driver.switchTo().parentFrame();
        
        
      //  Switch back to MIDDLE frame 
        driver.switchTo().frame( driver.findElement(By.cssSelector("frame[name='frame-middle']")));
         WebElement  middle= driver.findElement(By.xpath("//body"));
         String middletext=middle.getText();
         if (middletext.equals("MIDDLE")) {
        	 System.out.println("Verified: MIDDLE frame contains correct text");
         }else {
        	 System.out.println("Verification Failed: MIDDLE frame text mismatch.");
         }
        
      driver.switchTo().parentFrame();
      
      // Switch to right frame and verify text "RIGHT"
      driver.switchTo().frame( driver.findElement(By.cssSelector("frame[name='frame-right']")));
      WebElement  right= driver.findElement(By.xpath("//body"));
      String righttext=right.getText();
      if (righttext.equals("RIGHT")) {
     	 System.out.println("Verified: RIGHT frame contains correct text");
      }else {
     	 System.out.println("Verification Failed: RIGHT frame text mismatch.");
      }
     
      driver.switchTo().parentFrame();
   
   //Switch to bottom frame
      driver.switchTo().defaultContent();
      driver.switchTo().frame( driver.findElement(By.xpath("//frame[@name='frame-bottom']")));
      WebElement  bottom= driver.findElement(By.xpath("//body"));
      String bottomtext=bottom.getText();
      if (bottomtext.equals("BOTTOM")) {
     	 System.out.println("Verified: BOTTOM frame contains correct text");
      }else {
     	 System.out.println("Verification Failed: BOTTOM frame text mismatch.");
      }
     
      driver.switchTo().defaultContent();
      
      
        
    }
	}

/*OUTPUT
 * Verification Failed: Page title does not contain 'Frame'.
 * Verified: Top frame contains three frames.
 Verified: LEFT frame contains correct text.
Verified: MIDDLE frame contains correct text
Verified: RIGHT frame contains correct text
Verified: BOTTOM frame contains correct text*/
 

	
