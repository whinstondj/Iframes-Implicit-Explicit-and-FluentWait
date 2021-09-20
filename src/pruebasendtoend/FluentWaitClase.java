package pruebasendtoend;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class FluentWaitClase {
	WebDriver navegador = new ChromeDriver();
	
	@Test
	public void fluentWaitMetodo() {		
		//Este es el código de la Fluent Wait
		Wait<WebDriver> espera = new FluentWait<WebDriver>(navegador)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class); 
		
		navegador.get("http://automationpractice.com/index.php");
		navegador.manage().window().maximize();
		Actions mouseActions = new Actions(navegador);
		WebElement elementoProducto = navegador.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img"));
		mouseActions.moveToElement(elementoProducto).perform();
		navegador.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]")).click();
		
		WebElement ventanaProducto = espera.until( new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver navegador) {
				return navegador.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]"));
			}
		});

		System.out.println("Texto Header" + navegador.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")).getText());
		navegador.close();
	}

}
