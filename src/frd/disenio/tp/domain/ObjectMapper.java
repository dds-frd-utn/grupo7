package frd.disenio.tp.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

public class ObjectMapper {
	// Pagina hardcodeada.
	private String urlPagina = "http://www.betterjobs.com/jobRoll?DeveloperKey=9239e10c-9034-4763-bf4e-146f350d0b7a&FullDescription=true";
	private JSONParser parser = new JSONParser();

	// Baja el codigo fuente (en este caso el JSON) de una direccion web pasada
	// como parametro.
	private String downloadJSON(String url) throws IOException {
		URL urlpagina = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String linea;
		StringBuffer buffer = new StringBuffer();

		try {
			urlpagina = new URL(url);
			isr = new InputStreamReader(urlpagina.openStream());
			br = new BufferedReader(isr);
			while ((linea = br.readLine()) != null) {
				buffer.append(linea);
			}
			br.close();
			isr.close();
		} catch (MalformedURLException e) {
			System.out.println("Error en la url");
		}

		return buffer.toString();
	}

	// toma el json bajado y devuelve el campo results del mismo
	private JSONArray filterResults(String url) throws ParseException,
			IOException {
		String json = downloadJSON(url);
		JSONObject webSearchResponse = (JSONObject) parser.parse(json);
		webSearchResponse = (JSONObject) webSearchResponse
				.get("responseJobSearch");
		JSONArray results = (JSONArray) webSearchResponse.get("Results");

		return results;
	}

	// genera la lista con los trabajos
	@SuppressWarnings("unchecked")
	private List<Job> generateList(JSONArray results)
			throws IllegalArgumentException, IllegalAccessException {
		ArrayList<Job> jobsList = new ArrayList<Job>();
		results.forEach(job -> jobsList.add(createJob((JSONObject) job)));
		return jobsList;
	}

	// Devuelve una instancia de la clase Job con los atributos del JSON pasado
	// como parametro.
	private Job createJob(JSONObject jsonObject) {
		Job newJob = new Job();
		Class<Job> jobClass = Job.class;
		try {
			Field[] fields = jobClass.getFields();
			for (Field f : fields) {
				f.set(newJob, jsonObject.get(f.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newJob;
	}

	public List<Job> getJobs() throws ParseException, IOException,
			IllegalArgumentException, IllegalAccessException {
		return generateList(filterResults(urlPagina));
	}
}