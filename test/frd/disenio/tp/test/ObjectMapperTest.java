package frd.disenio.tp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import frd.disenio.tp.domain.Job;
import frd.disenio.tp.domain.ObjectMapper;

public class ObjectMapperTest {

	@Test
	public void bajaElTamanioCorrectoDeTrabajos() {
		ObjectMapper o = new ObjectMapper();
		List<Job> lista = new ArrayList<Job>();
		try {
			lista = o.getJobs();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(lista.size(), 25);
	}
	/* El contenido del json cambia con el tiempo -> no podemos hardcodear el string a comparar -> revisar
	 * 
	 * @Test public void bajaCorrectamenteElPrimerCampo() { ObjectMapper o = new
	 * ObjectMapper(); List<Job> lista = new ArrayList<Job>(); try { lista =
	 * o.getJobs(); } catch (Exception e) { e.printStackTrace(); } String
	 * compania = lista.get(0).getCompany();
	 * 
	 * assertEquals(compania,"Aerotek"); }
	 */
}
