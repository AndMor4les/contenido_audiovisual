/**
 * Class Documental
 */
package uni1a;

// Subclase Documental que extiende de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {
    private String tema;
   

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;        
    }
   
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
   @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
       
        System.out.println();
    }
   
   @Override
	   public ContenidoAudiovisual instancia(String [] campos) {
	   	// validamos que haya sificientes campos
	   	if (campos.length < 4) return null;
	   	try{
	   		String titulo = campos[0];
	   		int duracion = Integer.parseInt(campos[1]);
	   		String genero = campos[2];
	   		String tema =  campos[3];
	   		return new Documental(titulo, duracion,genero ,tema);
	   	} catch (NumberFormatException e) {
	   		System.out.println("Error convitiendo numero " + e.getMessage());
	   		return null;
	   	}
	   }
   
   @Override
		   public String escribir() {
		       return "Documental," + getTitulo() + "," + getDuracionEnMinutos() + "," +
		              getGenero() + "," + tema;
		   }
}