import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {




    @Test
    public void checkUrl() throws InterruptedException {

      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

      driver.get("https://next.privat24.ua/mobile");

      By PhoneNumber = By.xpath(".//input [@data-qa-node='phone-number']");
      driver.findElement(PhoneNumber).sendKeys("668349047");

      By Summa = By.xpath(".//input [@data-qa-node='amount']");
      driver.findElement(Summa).clear();
      driver.findElement(Summa).sendKeys("100");

      By CardNumber = By.xpath(".//input [@data-qa-node='numberdebitSource']");
      driver.findElement(CardNumber).sendKeys("5168 7559 0693 7319");

      By CardTermin = By.xpath(".//input [@data-qa-node='expiredebitSource']");
      driver.findElement(CardTermin).sendKeys("1023");

      By CVV = By.xpath(".//input [@data-qa-node='cvvdebitSource']");
      driver.findElement(CVV).sendKeys("123");

      Thread.sleep(2000);

      By ToBasket = By.xpath(".//button[@data-qa-node='submit']");
      driver.findElement(ToBasket).click();

      Thread.sleep(2000);

      By CardA = By.xpath(".//td[@data-qa-node='card']");
      Assert.assertEquals("5168 **** **** 7319", driver.findElement(CardA).getText());

      By Vodafonetag = By.xpath(".//span[@data-qa-node='nameB']");
      Assert.assertEquals("Vodafone", driver.findElement(Vodafonetag).getText());

      By Summ = By.xpath(".//span[@data-qa-node='amount']");
      Assert.assertEquals("100", driver.findElement(Summ).getText());

      driver.findElement(By.xpath(".//button[contains(text(), 'Підтвердити')]")).click();