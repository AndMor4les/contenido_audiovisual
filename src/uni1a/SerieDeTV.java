/**
 * Class SerieDeTV
 */
package uni1a;



// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    //private int temporadas;
    private int temporadas;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
    } 
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la serie:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + this.temporadas);      
        System.out.println();
    }
    
    @Override
    protected ContenidoAudiovisual instancia(String [] campos) {
    	// validamos que haya sificientes campos
    	if (campos.length < 4) return null;
    	try{
    		String titulo = campos[0];
    		int duracion = Integer.parseInt(campos[1]);
    		String tema = campos[2];
    		int temporada =  Integer.parseInt(campos[3]);
    		return new SerieDeTV(titulo, duracion, tema,temporada);
    	} catch (NumberFormatException e) {
    		System.out.println("Error convitiendo numero " + e.getMessage());
    		return null;
    	}
    }
    
    @Override
    public String escribir() {
        return "Serie," + getTitulo() + "," + getDuracionEnMinutos() + "," +
               getGenero() + "," + temporadas;
    }
}