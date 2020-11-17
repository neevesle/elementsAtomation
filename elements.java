package elementsAtomation;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class elements {
	
	private WebDriver navegador; // declarando variavel navegador  como global para ser vista pelos outros metodo 
	
	@Before
			public void setUp() {
		
	
	//abrir navegador chromedriver
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Neves\\Downloads\\chromedriver_win32\\chromedriver.exe");
	
	ChromeOptions chromeOptions = new ChromeOptions ();
	chromeOptions.addArguments("incognito");
	chromeOptions.addArguments("--disable-web-security");
	chromeOptions.setExperimentalOption("useAutomationExtension", false);
				
	//importar o webDrive como navegador padrão 
	navegador = new ChromeDriver(chromeOptions);
	
	//navegar para uma pagina na internet "navegador, chama um metodo pra o navegador
	navegador.get("https://ultimateqa.com/filling-out-forms/");

	}
	
@Test

public void testeCampoUm () {
	
	//Digitar no campo "name" que está dentro do id "et_pb_contact_name_0" o texto "leticia1"
	navegador.findElement(By.id("et_pb_contact_name_0")).sendKeys("leticia1");
	
	//Digitar no campo "mensage" que está dentro do id "et_pb_contact_name_0" o texto "teste1"
	navegador.findElement(By.id("et_pb_contact_message_0")).sendKeys("teste1");
	
	//Clicar no link com o texto "Submit"
	navegador.findElement(By.xpath("//*[@id=\"et_pb_contact_form_0\"]/div[2]/form/div/button")).click();

	}

@Test

public void testeCampoDois () {
	
	//Digitar no campo "name" que está dentro do id "et_pb_contact_name_1" o texto "leticia2"
	navegador.findElement(By.id("et_pb_contact_name_1")).sendKeys("leticia2");
	
	//Digitar no campo "mensage" que está dentro do id "et_pb_contact_message_1" o texto "teste2"
	navegador.findElement(By.id("et_pb_contact_message_1")).sendKeys("teste2");
	
	navegador.findElement(By.className("et_pb_contact_captcha_question")).click();
	
	String teste = navegador.findElement(By.className("et_pb_contact_captcha_question")).getText();
	System.out.println(teste);
	
	int primeiroNumero = Integer.parseInt(teste.substring (0,1));
	int segundoNumero = Integer.parseInt(teste.substring(teste.length() - 1));
	int resultado = (primeiroNumero + segundoNumero);
	
	System.out.println(resultado);
	
	//Digitar valor da soma que está dentro no class "input et_pb_contact_captcha" o texto "resultado"
	navegador.findElement(By.className("et_pb_contact_captcha")).sendKeys(Integer.toString(resultado));
	
	//Clicar no link com o texto "Submit"
	navegador.findElement(By.xpath("//*[@id=\"et_pb_contact_form_1\"]/div[2]/form/div/button")).click();
	
	}

}


