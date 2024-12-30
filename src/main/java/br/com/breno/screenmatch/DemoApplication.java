package br.com.breno.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.breno.screenmatch.model.DadosSeries;
import br.com.breno.screenmatch.services.ConsumoApi;
import br.com.breno.screenmatch.services.ConverterDados;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	   var consumoapi = new ConsumoApi();
	   var json = consumoapi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=b12890d5");
	   
	   System.out.println(json);
	   
	   ConverterDados conversor = new ConverterDados();
	   
	   DadosSeries dados = conversor.obterDados(json, DadosSeries.class);
	   System.out.println(dados);
		
		
	}

}
