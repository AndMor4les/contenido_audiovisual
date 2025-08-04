package poo;
import java.util.ArrayList;
import java.util.List;

import uni1a.*;
import escritura.Guardar;
public class PruebaAudioVisual {
	public static void main(String[] args) {
		
		
		/*
		 * MODELO VISTA
		 */
		
		System.out.println("============================================");
        System.out.println("Peliculas");
        System.out.println("============================================");
		
		Pelicula p = new Pelicula("", 0, "", "");// se crea una instancia del objeto vacio porque no es estatico
        
		List<ContenidoAudiovisual> peliculas = p.leerDesdeCSV("peliculas.txt");       
		
        // Mostrar los detalles de cada contenido audiovisual
		        for (ContenidoAudiovisual contenido : peliculas) {
		        	((ContenidoAudiovisual) contenido).mostrarDetalles();
		        }
		       
        
        System.out.println("============================================");
        System.out.println("Series de TV");
        System.out.println("============================================");
        
        SerieDeTV serie = new SerieDeTV("",0,"",0);
        
        List<ContenidoAudiovisual> series = serie.leerDesdeCSV("seriesDeTv.txt");
        		 for (ContenidoAudiovisual contenido : series) {
        	        	((ContenidoAudiovisual) contenido).mostrarDetalles();
        	        }
        
        		
        		 
        System.out.println("============================================");
        System.out.println("Documentales");
        System.out.println("============================================");
        
        Documental contenido = new Documental("",0,"","");
        List<ContenidoAudiovisual> documentales = contenido.leerDesdeCSV("documental.txt");
		        for (ContenidoAudiovisual d : documentales) {
		        	((ContenidoAudiovisual) d).mostrarDetalles();
        }
		        
		        
	       //	Lista par guardar todos los contenidos en un solo lugar
		        
	      List<ContenidoAudiovisual> todosLosContenidos = new ArrayList<>();
	      
	      todosLosContenidos.addAll(peliculas);
	      todosLosContenidos.addAll(series);
	      todosLosContenidos.addAll(documentales);
	      
	      Guardar.guardarContenidos(todosLosContenidos, "todosLosContenidosAudiovisuales.txt");
    }
}