package br.com.breno.screenmatch.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.com.breno.screenmatch.model.DadosSeries;
import br.com.breno.screenmatch.model.DadosTemporada;
import br.com.breno.screenmatch.services.ConsumoApi;
import br.com.breno.screenmatch.services.ConverterDados;

public class Principal {

	private Scanner leitura = new Scanner(System.in);
	private final String ENDERECO =  "http://www.omdbapi.com/?t=";
	private final String API_KEY = "&apikey=b12890d5";
	private ConsumoApi consumoApi = new ConsumoApi();
	private ConverterDados converterDados = new ConverterDados();


	public void exibeMenu() {

		System.out.println("Digite o nome da série para pesquisa");

		var nomeSerie = leitura.nextLine();

		var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
		DadosSeries dados = converterDados.obterDados(json, DadosSeries.class);

		System.out.println(dados);

		List<DadosTemporada> temporadas = new ArrayList<>();

		for(int i =1; i<= dados.totalTemporadas(); i++ ) {
			json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") +"&season="+ i + API_KEY);
 
			DadosTemporada dadosTemporada = converterDados.obterDados(json, DadosTemporada.class);

			temporadas.add(dadosTemporada);
		}

		temporadas.forEach(System.out::println);
		
//		for(int i = 0; i < dados.totalTemporadas(); i++){
//			 List<DadosEpisodeos> episodeosTemporada = temporadas.get(i).episodeos();
//			 for(int j = 0; j< episodeosTemporada.size(); j++) {
//				 System.out.println(episodeosTemporada.get(j).titulo());
//				 }
//		}
		
		temporadas.forEach(t -> t.episodeos().forEach(e -> System.out.println(e.titulo())));
		
		
		
		
		
	}
}




