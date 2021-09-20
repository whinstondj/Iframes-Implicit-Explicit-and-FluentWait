package pruebasendtoend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframesPrueba {
	
	WebDriver navegador = new ChromeDriver();
	
	@Test
	public void trabajarConIframe() {
		navegador.get("https://winstoncastillo.com/ejercicios/atoc.html");
		navegador.manage().window().maximize();
		System.out.println(navegador.findElements(By.tagName("iframe")).size());
		navegador.switchTo().frame("iframe-prueba");
		System.out.println(navegador.findElement(By.xpath("//*[@id=\"elemento01\"]/a")).getText());
		//navegador.switchTo().defaultContent();
		navegador.switchTo().parentFrame();
		System.out.println(navegador.findElement(By.xpath("/html/body/div/section[6]/p[1]/span[1]")).getText());
		navegador.close();
		
	}
	

}
