package seleniumAssignment;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentYammer 
{
	    static WebDriver driver;
        public static void main(String[] args) throws Exception 
        {
		// TODO Auto-generated method stub
	   
		System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\jaganag\\eclipse-workspace\\jarfiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.navigate().to("https://web.yammer.com/main/capgemini.com/");
		WebElement mail = driver.findElement(By.id("i0116"));
		mail.sendKeys("jaganath.g@capgemini.com");
	    WebElement nxtButton = driver.findElement(By.id("idSIButton9"));
	    nxtButton.click();
//		WebElement mobilePass = driver.findElement(By.id("password"));
//		mobilePass.sendKeys("041120");
//	    WebElement soButton = driver.findElement(By.id("signOnButton"));
//		soButton.click();
	   
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    
		WebElement accept=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"idSIButton9\"]")));
		accept.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.linkText("OneTeamOneFamily"))));
		driver.findElement(By.linkText("OneTeamOneFamily")).click();
		
//		WebElement share = driver.findElement(By.xpath("//div[text()='Share thoughts, ideas, or updates']"));
//		share.click();
//		WebElement content = driver.findElement(By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']"));
//		content.sendKeys("Hi team");
		
		List posts= new ArrayList();
		Map<Integer,WebElement > map= new TreeMap();
		
		WebElement list=null;
		for(int j=1;j<5 ;j++) 
			{
			list= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li["+j+"]/div/div/div/div/div/div/div[1]/div[5]/div[2]/div/div/div/div/div[2]/div/div/div/button/span/div"));
			System.out.println("running "+ j);
			JavascriptExecutor executor= (JavascriptExecutor) driver;
	        }
        String a=list.getText().substring(0, 2).replaceAll(" ","");
		
		int num=Integer.parseInt(a);
		posts.add(num);
		map.put( num,list);
		
		Collections.sort(posts);
		
		System.out.println(posts.get(posts.size()-1));
		System.out.println(map.get(posts.get(posts.size()-1)));
		WebElement mostLikedLocator = map.get(posts.get(posts.size()-1));
		
		allPosts();
		JavascriptExecutor executor2= (JavascriptExecutor) driver;
		String js = "window.scrollBy"+mostLikedLocator.getLocation();
		executor2.executeScript(js);
		System.out.println("Most liked post location: "+mostLikedLocator.getLocation());
		
		//Take SS of post
		File srcfile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile1, new File("./Pictures/image.png"));
		
		}
		public static void allPosts() throws InterruptedException
		{
		//get all posts present
		
		List<WebElement> allPost= driver.findElements(By.xpath("//ul[@class='layoutList-552']//li[@class='y-layoutList--item qaFeedThread layoutListItem-162']"));
		
		System.out.println(allPost.size());
		List addNumber= new ArrayList();
		List <WebElement> list= driver.findElements(By.xpath("//ul[@class='layoutList-552']//li[@class='y-layoutList--item qaFeedThread layoutListItem-162']//span[@class='y-fakeLink']//div[@class='ms-TooltipHost root-394']"));
		for(int i=0;i<list.size();i++) 
			{
			String a=list.get(i).getText().substring(0, 2).replaceAll(" ","");
			int num=Integer.parseInt(a);
			addNumber.add(num);
			}
		Collections.sort(addNumber);
		System.out.println("addNumber List: "+addNumber);
		}
}