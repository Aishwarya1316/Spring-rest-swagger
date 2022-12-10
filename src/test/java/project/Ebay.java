package project;
	
	import java.util.List;
	import java.util.Scanner;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;



	public class Ebay {  
		public static WebDriver driver;
		private Scanner sc;
		public void browserSelect()
		{
			
	//Option to choose the browser
			System.out.println("Select your Browser\n 1.Chrome\n 2.Firefox\n 3.Edge");
			sc = new Scanner(System.in);
			int choice=sc.nextInt();
			
	//selecting the required browser with variable
			if(choice==1)
			{
				chromeBrowser();
			}
			else if(choice==2){
				fireFox();
			}
			else {
				edgeBrowser();

}
		}
		public static void chromeBrowser()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Home\\Downloads\\Outdoor-20221117T052229Z-001\\Outdoor\\Resources\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
	// Method to launch the Edge browser
		public static void edgeBrowser()
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\Home\\Downloads\\Outdoor-20221117T052229Z-001\\Outdoor\\Resources\\msedgedriver.exe");
			driver =new EdgeDriver();
		}
		
	//Method to launch the firefox browser
		public static void fireFox()
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Home\\Downloads\\Outdoor-20221117T052229Z-001\\Outdoor\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

			public static void main(String[] args) throws InterruptedException {
				Ebay n =new Ebay();
				n.browserSelect();
				
	// TODO Auto-generated method stub
		

	//Maximize the window.	
		driver.get("http://www.ebay.com");	
		driver.manage().window().maximize();
		
	//Locate �advanced� Search button and click on it.	
		driver.findElement(By.id("gh-as-a")).click();
		
	//Enter "outdoor toys" in the Enter keywords	
		driver.findElement(By.id("_nkw")).sendKeys("outdoor toys");
		
	//Select the checkbox �New� under Condition	
		driver.findElement(By.id("LH_ItemConditionNew")).click();
		
	//Select From preferred locations as �Worldwide.(From Dropdown menu)�	
		WebElement pL = driver.findElement(By.id("_sargnSelect")); 
		Select preLoc = new Select(pL);
		preLoc.selectByIndex(1);
		
	//Click on �Search� button	
		driver.findElement(By.id("searchBtnLowerLnk")).click();
		
	//Selecting dropdown box	
		Select ver = new  Select(driver.findElement(By.id("gh-cat")));
		WebElement verify = ver.getFirstSelectedOption();
		
	// verifying the text in the dropdown using if condition	
		String check = verify.getText(); 
		if(check.equals("Outdoor Toys & Structures"))

		{
		 System.out.println("Outdoor Toys & Structures option got selected succesfully");
		}
		else
		{
			System.out.println("Outdoor Toys & Structures option not selected succesfully");
		}
		
	//selecting and verifying links with text	
		List<WebElement> links=driver.findElements(By.tagName("a"));//selecting and verifying links with text
		  String s = driver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[4]/div[2]/div[1]/div[2]/ul[1]/li[2]/div[1]/div[2]/a[1]/div[1]")).getText();
		  String a = driver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[4]/div[2]/div[1]/div[2]/ul[1]/li[5]/div[1]/div[2]/a[1]/div[1]")).getText();
		  if(s.equals("portable")) {
			
			
	// printing items names 			
				System.out.println(a); 
			}
			else
			
			{
				
	// printing items names 			
				System.out.println(s); 
			}
			
	//closing the browser.		
			driver.quit();
			
		}

		}


