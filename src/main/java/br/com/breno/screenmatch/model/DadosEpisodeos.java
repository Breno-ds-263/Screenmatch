package br.com.breno.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodeos(@JsonAlias("Title") String titulo,
		                     @JsonAlias("Episode") Integer numero,
		                     @JsonAlias("imdbRating") String  avalicacao,
		                     @JsonAlias("Released") String dataLancamento) {

}
