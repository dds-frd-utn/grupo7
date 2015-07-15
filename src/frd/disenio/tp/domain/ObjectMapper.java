package frd.disenio.tp.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

public class ObjectMapper {
	// Pagina hardcodeada.
	private String urlPagina = "http://www.betterjobs.com/jobRoll?DeveloperKey=9239e10c-9034-4763-bf4e-146f350d0b7a&FullDescription=true";
	private JSONParser parser = new JSONParser(); // parser de JSON

	// Baja el codigo fuente (en este caso el JSON) de una dirección web pasada como parametro.
	private String downloadJSON(String url) {
	    URL urlpagina = null;
	    InputStreamReader isr = null;
	    BufferedReader br = null;
	    String linea;
	    StringBuffer buffer = new StringBuffer();

	    try {
	      urlpagina = new URL(url);
	      isr = new InputStreamReader(urlpagina.openStream());
	      br = new BufferedReader(isr);
	      while ((linea = br.readLine()) != null){
	        buffer.append(linea);
	      }
	      br.close();
	      isr.close();
	    } catch (MalformedURLException e) {
	      System.out.println("Error en la url");
	    } catch (IOException e) {
	      System.out.println("Error al leer la pagina web");
	    }

	    return buffer.toString();
	}
	
	// toma el json bajado y devuelve el campo results del mismo
	private JSONArray filterResults(String url) throws ParseException {
		String json = downloadJSON(url);
		JSONObject webSearchResponse = (JSONObject) parser.parse(json);
		webSearchResponse = (JSONObject) webSearchResponse.get("responseJobSearch");
		JSONArray results = (JSONArray) webSearchResponse.get("Results");
		
		return results;
	}

	// genera la lista con los trabajos
	private List<Job> generateList(JSONArray results) {
		ArrayList<Job> jobsList = new ArrayList<Job>();
		Iterator<JSONObject> jobIter = results.iterator(); // iterador de trabajo
		while (jobIter.hasNext()) {
			jobsList.add(createJob(jobIter.next()));
		}

		return jobsList;
	}
	
	// Devuelve una instancia de la clase Job con los atributos del JSON pasado como parametro.
	private Job createJob(JSONObject jsonObject) {
		Job newJob = new Job();
		
		newJob.setCity((String) jsonObject.get("city"));
		newJob.setCompany((String) jsonObject.get("company"));
		newJob.setCompanyDetailsURL((String) jsonObject.get("companyDetailsURL"));
		newJob.setCountry((String) jsonObject.get("country"));
		newJob.setDistance((String) jsonObject.get("distance"));
		newJob.setDocumentID((String) jsonObject.get("documentID"));
		newJob.setEmploymentType((String) jsonObject.get("employmentType"));
		newJob.setHighlight((String) jsonObject.get("highlight"));
		newJob.setJobDetails((String) jsonObject.get("jobDetails"));
		newJob.setJobDetailsURL((String) jsonObject.get("jobDetailsURL"));
		newJob.setJobServiceURL((String) jsonObject.get("jobServiceURL"));
		newJob.setJobTitle((String) jsonObject.get("jobTitle"));
		newJob.setLocation((String) jsonObject.get("location"));
		newJob.setLocationLat((String) jsonObject.get("locationLat"));
		newJob.setLocationLon((String) jsonObject.get("locationLon"));
		newJob.setPay((String) jsonObject.get("pay"));
		newJob.setPostedDate((String) jsonObject.get("postedDate"));
		newJob.setShowSocCode((boolean) jsonObject.get("showSocCode"));
		newJob.setSimilarJobsURL((String) jsonObject.get("similarJobsURL"));
		newJob.setSocCode((String) jsonObject.get("socCode"));
		newJob.setSource((String) jsonObject.get("source"));
		newJob.setState((String) jsonObject.get("state"));
		
		return newJob;
	}

	public List<Job> getJobs() throws ParseException {
		return generateList(filterResults(urlPagina));
	}
}
