package frd.disenio.tp.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ObjectMapper {
	// Pagina hardcodeada.
	private String urlPagina = "http://www.betterjobs.com/jobRoll?DeveloperKey=9239e10c-9034-4763-bf4e-146f350d0b7a&FullDescription=true";
	private JSONParser parser = new JSONParser(); // parser de JSON

	private JSONObject filterResults(String jsonBajado) throws ParseException { // toma el json bajado y devuelve el campo "results" del mismo.
		String json = Wget.apply(jsonBajado);
		JSONObject webSearchResponse = (JSONObject) ((HashMap) parser
				.parse(json)).get(0); // campo webSearchResponse
		JSONObject results = (JSONObject) webSearchResponse.get(6); // campo results
		return results;
	}

	private List<Job> generateList(JSONObject results) { // genera la lista con los trabajos
		// TODO
		ArrayList<Job> lista = new ArrayList<Job>();
		return lista;
	}
	
	public List<Job> getJobs() throws ParseException {
		return generateList(filterResults(urlPagina));
	}
	

}
