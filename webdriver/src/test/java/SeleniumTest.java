import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.lang.Math;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SeleniumTest {


    String link = "https://www.random.org/coins/";
    String link_library = "https://sites.google.com/view/library-automation-lits/home";

    String email = "asohanskyy@gmail.com";
    String pass = "Qwerty123456";



    @BeforeTest

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");

    }

    @Test
    public void check_rand() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(link);


        if(driver.getPageSource().contains("True Random Number Service")) {
        }

        else{
            throw new InterruptedException("No such text on page");
        }


        if(driver.getPageSource().contains("Coin Flipper")) {
        }

        else{
            throw new InterruptedException("No such text on page2");
        }



        Select dropdown_flip = new Select(driver.findElement(By.name("num")));
        dropdown_flip.selectByValue("200");

        Select dropdown_coin = new Select(driver.findElement(By.name("cur")));
        dropdown_coin.selectByVisibleText("Maximinus - Bronze/Silver Tetradrachm - Roman Empire");

        WebElement flip_button = driver.findElement(By.xpath("//input[@value='Flip Coin(s)']"));
        flip_button.submit();

        List<WebElement> obverse = driver.findElements(By.xpath("//img[contains(@title,'obverse')]"));
        int obverse_count = obverse.size();
        System.out.println("Number of observed coins: " + obverse_count);

        List<WebElement> reverse = driver.findElements(By.xpath("//img[contains(@title,'reverse')]"));
        int reverse_count = reverse.size();
        System.out.println("Number of reversed coins: " + reverse_count);

        double ratio = (((double) obverse_count/ (double) reverse_count) * 100) - 100;

        System.out.println(ratio);

        ratio = Math.sqrt(ratio * ratio);

        System.out.println(ratio);

        if (ratio > 10.0) {
            throw new InterruptedException("Ratio is not in normal range: ratio > 10.0 ");
        }

        WebElement back = driver.findElement(By.xpath("//input[@value='Go Back']"));
        back.click();


        Select dropdown_flip2 = new Select(driver.findElement(By.name("num")));
        dropdown_flip2.selectByValue("20");

        Select dropdown_coin2 = new Select(driver.findElement(By.name("cur")));
        dropdown_coin2.selectByVisibleText("American Voting Coin 2004");

        WebElement flip_button2 = driver.findElement(By.xpath("//input[@value='Flip Coin(s)']"));
        flip_button2.submit();


        List<WebElement> obverse2 = driver.findElements(By.xpath("//img[contains(@title,'obverse')]"));
        int obverse_count2 = obverse.size();
        System.out.println("Number of observed coins: " + obverse_count);

        List<WebElement> reverse2 = driver.findElements(By.xpath("//img[contains(@title,'reverse')]"));
        int reverse_count2 = reverse.size();
        System.out.println("Number of reversed coins: " + reverse_count);

        double ratio2 = (((double) obverse_count/ (double) reverse_count) * 100) - 100;

        System.out.println(ratio2);

        ratio = Math.sqrt(ratio2 * ratio2);

        System.out.println(ratio2);

        if (ratio2 > 10.0) {
            throw new InterruptedException("Ratio is not in normal range: ratio2 > 10.0 ");
        }



      //  Thread.sleep(3000);
      //  driver.quit();
    }




    @Test
    public void check_library() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        String link_z = "https://dev-s-5l13fi.auth0.com/login?state=g6Fo2SBUV3pMZ3hvUGJoNFBnSm9fZ3FsY3VsZ1J2dmFNT245TqN0aWTZIEFUdklJOFJsMEhoZXc1V3o5VjBZTVMxY2xLelFPcjRuo2NpZNkgMXJhYzlzSHJMZkNQQWxHbUtHSFd0Vkk4NEFVWnJNc0o&client=1rac9sHrLfCPAlGmKGHWtVI84AUZrMsJ&protocol=oauth2&redirect_uri=https%3A%2F%2Fsearch-app-263e2.web.app&scope=openid%20profile%20email&response_type=code&response_mode=query&nonce=OZtZj-PpQUOjx4uL6YcjnjmdqSrVOHMiEe-8dBtgHOB&code_challenge=ZOzJv2REhIlocUGNOPZMmhon4RyOS9Lm9DbrzDLKCps&code_challenge_method=S256&auth0Client=eyJuYW1lIjoiYXV0aDAtc3BhLWpzIiwidmVyc2lvbiI6IjEuNi4yIn0%3D";

        driver.get(link_library);
        //driver.get(link_z);

        WebElement login = driver.findElement(By.xpath("//div[@id='h.p_Mn9dCRJZ_dHM']/div/div/div/a/div/p"));

        login.click();

        driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));

        WebElement email_field = driver.findElement(By.id("email"));
        email_field.sendKeys(email);

        WebElement pass_field = driver.findElement(By.id("password"));
        pass_field.sendKeys(pass);

        WebElement submit_b = driver.findElement(By.id("btn-login"));
        submit_b.click();


        //driver.quit();
    }



    @Test
    public void google() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        String link_z = "https://accounts.google.com/signin/v2/identifier?hl=ru&passive=true&continue=https%3A%2F%2Fwww.google.com.ua%2F&flowName=GlifWebSignIn&flowEntry=ServiceLogin";


        driver.get(link_z);

        WebElement user = driver.findElement(By.name("identifier"));

        user.sendKeys("aaa159815@gmail.com");


        WebElement next = driver.findElement(By.xpath("//div[@id='identifierNext']//span[@class='RveJvd snByac']"));
        next.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement pass = driver.findElement(By.name("password"));

        wait.until(ExpectedConditions.elementToBeClickable(pass));

        pass.sendKeys("qwerty123123");

        WebElement next_pass = driver.findElement(By.xpath("//div[@id='passwordNext']//span[@class='RveJvd snByac']"));
        next_pass.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //driver.close();



    }



}
