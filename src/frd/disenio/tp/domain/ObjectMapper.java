package frd.disenio.tp.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
// Hola
	// toma el json bajado y devuelve el campo results del mismo
	private JSONObject filterResults(String jsonBajado) throws ParseException {
		ContainerFactory containerFactory = new ContainerFactory() {
			public List creatArrayContainer() {
				return new LinkedList();
			}

			public Map createObjectContainer() {
				return new LinkedHashMap();
			}
		};
		String json = Wget.apply(jsonBajado);
		JSONObject webSearchResponse = (JSONObject) ((HashMap) parser.parse(
				json, containerFactory)).get(0); // campo webSearchResponse
		JSONObject results = (JSONObject) webSearchResponse.get(6);
		// devuelve campo results del json como un JSONObject (Map)
		return results;
	}

	// genera la lista con los trabajos
	private List<Job> generateList(JSONObject results) {
		ArrayList<Job> jobsList = new ArrayList<Job>();
		Iterator jobIter = results.entrySet().iterator(); // iterador de trabajo
		while (jobIter.hasNext()) {
			Map.Entry jobMap = (Map.Entry) jobIter.next();
			Iterator fieldIter = ((HashMap) jobMap.getValue()).entrySet()
					.iterator(); // iterador de campo del trabajo
			while (fieldIter.hasNext()) {
				// TODO
				// Aca deberia ir la logica de instanciar los trabajos con los
				// datos de cada campo
				// del json e ir agregandolos a la lista jobList
			}
		}

		return jobsList;
	}

	public List<Job> getJobs() throws ParseException {
		return generateList(filterResults(urlPagina));
	}

}
