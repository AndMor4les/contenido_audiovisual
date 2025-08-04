package escritura;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import uni1a.ContenidoAudiovisual;

public class Guardar {

	//static: para poder llamarlo sin crear un objeto de la clase
	public static void guardarContenidos(List<ContenidoAudiovisual> contenidos, String archivo) {
		//	try-with-resources (asegura que el archivo se cierra automaticamente al terminar)
		try (PrintWriter escribir = new PrintWriter( new FileWriter(archivo))){
			
						
			// procesar cada objeto para convertirlo en una línea de texto
			//	for -each
			for ( ContenidoAudiovisual c : contenidos) {
				//	polimorfismo
				//	llama a toCSV según sea el tipo real del objeto
				escribir.println(c.escribir());
				
			}
			
			System.out.println("Contenidos guardados en: "+ archivo);
			
		} catch (IOException e) {
			System.err.println("Error al guardar:  "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
