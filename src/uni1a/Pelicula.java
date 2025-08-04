/**
 * Class Pelicula
 */
package uni1a;

// Subclase Pelicula que extiende de ContenidoAudiovisual
public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
    
  
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio); 
               
        System.out.println();
    }
    
    @Override
    protected ContenidoAudiovisual instancia(String [] campos) {
    	// validamos que haya sificientes campos
    	if (campos.length < 4) return null;
    	try{
    		String nombre = campos[0];
    		int duracion = Integer.parseInt(campos[1]);
    		String tema = campos[2];
    		String estudio =  campos[3];
    		return new Pelicula(nombre, duracion, tema,estudio);
    	} catch (NumberFormatException e) {
    		System.out.println("Error convitiendo numero " + e.getMessage());
    		return null;
    	}
    }
    
    @Override
	    public String escribir() {
	        return "Pelicula," + getTitulo() + "," + getDuracionEnMinutos() + "," +
	               getGenero() + "," + estudio;
	    }
    
}