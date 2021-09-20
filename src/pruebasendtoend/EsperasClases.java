package pruebasendtoend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EsperasClases {
	WebDriver navegador = new ChromeDriver();
	
	@Test
	public void esperaImplicitaExplicita() {
		//Este es el código de una espera Implicita
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Este es el código de la espera explicita
		WebDriverWait espera = new WebDriverWait(navegador, 10); 
		
		navegador.get("http://automationpractice.com/index.php");
		navegador.manage().window().maximize();
		Actions mouseActions = new Actions(navegador);
		WebElement elementoProducto = navegador.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img"));
		mouseActions.moveToElement(elementoProducto).perform();
		navegador.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]")).click();
		
		WebElement ventanaProducto = espera.until(ExpectedConditions.visibilityOf(navegador.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]"))));

		System.out.println("Texto Header" + navegador.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")).getText());
		navegador.close();
	}
}
