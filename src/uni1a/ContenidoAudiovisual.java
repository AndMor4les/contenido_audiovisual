package uni1a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ContenidoAudiovisual {
    private static int contar = 0;
    private String titulo;
    private int duracionEnMinutos;
    private String genero;
    private int id;

    public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
        this.id = contar++;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }

    // Getter y Setter para el campo 'titulo'
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter y Setter para el campo 'duracionEnMinutos'
    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    // Getter y Setter para el campo 'genero'
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Getter para el campo 'id' (no se proporciona el Setter ya que 'id' se asigna en el constructor y parece ser inmutable)
    public int getId() {
        return id;
    }
   
    
    
    /*
     * Single Responsability Principle
     * 		Una clase, una sola tarea
     * 
     * Open/Closed Principle
     * 		Entidad habierta para extencion, pero cerrada para modificación
     * 
     * Liskov Substitution Principle
     * 		Las clases derivaras deberan implementar el metodo sin romper el comportamiento
     */
    
 // implementar LECTOR
    public  List<ContenidoAudiovisual> leerDesdeCSV(String rutaArchivo){
    	List<ContenidoAudiovisual> lista = new ArrayList<>();
    	
    	try ( BufferedReader br = new BufferedReader( new FileReader(rutaArchivo) ) ){
    		String linea;
    		boolean esPrimeraLinea = true;
    		
	    		while (( linea = br.readLine()) != null) {
	    			
	    			// para saltar el encabezado
	    			if (esPrimeraLinea) {
	    				esPrimeraLinea = false;
	    				continue;
	    			}
	    			
		    			String [] campos = linea.split(",");
		    			
		    			// llamada al método abstracto
		    			ContenidoAudiovisual contenido = instancia(campos);
		    			
		    			if (contenido != null) {
		    				lista.add(contenido);
		        			        			
		        		}
	    		}
    		} catch (IOException e) {
    			System.out.println("Error al leer el archivo: " + e.getMessage());
    			    			
    		}
    		return lista;
    	}
    /*
     * Dependency inversion Principle
     * 		Las clases hijas dependen de abstracciones, no de implementaciones concretas
     */
    // métodos abstractos que cada hija debe implementar
	    protected  abstract ContenidoAudiovisual instancia(String[] campos);

		public abstract void mostrarDetalles();
		
		// para guardar los contenidos en cada una de las clases hijas
		public abstract String escribir();
	     
    
    }
    
  