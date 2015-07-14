package frd.disenio.tp.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Wget {
	public static String apply(String url) {
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
	      System.out.println("Error la url");
	    } catch (IOException e) {
	      System.out.println("Error al leer la pagina web");
	    }

	    return buffer.toString();
	}
}
