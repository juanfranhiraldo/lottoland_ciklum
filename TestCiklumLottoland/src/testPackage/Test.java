package testPackage;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
	static WebDriver driver;
	final String[] names={"Jan van Dam", "Chack Norris", "Klark n Kent", "John Daw", "Bat Man", "Tim Los", "Dave o Core", "Pay Pal", "Lazy Cat", "Jack & Johnes"};
	final List<User> users=User.returnListOfUsers(names);
	static List<User> addedUsers=new ArrayList<User>();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    driver=new ChromeDriver(options);
	    
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@org.junit.Test
	public void test() {
		driver.get(" http://demoqa.com/registration/");
		Assert.assertTrue(driver.getCurrentUrl().equals("http://demoqa.com/registration/"));
		String[] resToPrint=names;
		List<User> addedUsers=new ArrayList<User>();
		for(int i=0;i<5;i++){
			User user=registerRandomUser();
			addedUsers.add(user);
			deleteFrom(resToPrint,user.getCompleteName());
		}
		for(int i=0;i<resToPrint.length;i++){
			System.out.println(resToPrint[i]);
		}
	}

	private void deleteFrom(String[] resToPrint, String completeName) {
		// TODO Auto-generated method stub
		
	}

	private User registerRandomUser() {
		Random r=new Random(System.currentTimeMillis());
		User userToAdd=users.get(r.nextInt(users.size()));
		while(addedUsers.contains(userToAdd)){
			userToAdd=users.get(r.nextInt(users.size()));
		}
		driver.findElement(By.id("name_3_firstname")).sendKeys(userToAdd.firstName);
		driver.findElement(By.id("name_3_lastname")).sendKeys(userToAdd.lastName);
		driver.findElement(By.cssSelector("input[value='"+RandomizeData.randomizeMarital()+"']")).click();
		String randomHobbies[]=RandomizeData.randomizeHobbies();
		for(int i=0;i<randomHobbies.length;i++){
			driver.findElement(By.cssSelector("input[value='"+randomHobbies[i]+"']")).click();
		}
		driver.findElement(By.id("dropdown_7")).click();
		driver.findElement(By.id("dropdown_7")).sendKeys(RandomizeData.randomizeCountry());
		driver.findElement(By.id("dropdown_7")).sendKeys(Keys.RETURN);
		Date date=RandomizeData.randomizeDate();
		driver.findElement(By.id("mm_date_8")).findElement(By.cssSelector("option[value='"+date.getMonth()+"'")).click();
		driver.findElement(By.id("dd_date_8")).findElement(By.cssSelector("option[value='"+date.getDay()+"'")).click();
		driver.findElement(By.id("yy_date_8")).findElement(By.cssSelector("option[value='"+date.getYear()+"'")).click();
		return userToAdd;
	}

}
