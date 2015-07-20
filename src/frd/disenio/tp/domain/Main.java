package frd.disenio.tp.domain;

import java.util.List;

import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
		
		ObjectMapper o = new ObjectMapper();
		
		try {
			List<Job> listaFede  = o.getJobs();
			for (Job job : listaFede)
				System.out.println(job.getCompany() + ' '+ job.getCountry());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
