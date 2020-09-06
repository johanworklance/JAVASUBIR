package uniandes.cupi2.avion.mundo;

/**
 * Pelicula a emitir
 */
public class Pelicula {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	// Generos de Pelicula
	public final static String COMEDIA = "Comedia";

	public final static String ACCION = "Acción";

	public final static String DRAMA = "Drama";

	public final static String INFANTIL = "Infantil";

	public final static String ROMANCE = "Romance";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	// nombre de la pelicula
	private String nombre;
	// genero de la pelicula
	private String genero;
	// duracion de la pelicula
	private int duracion;
	// director de la pelicula
	private String director;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	public Pelicula(String pNombre, String pGenero, int pDuracion, String pDirector) {
		nombre = pNombre;
		genero = pGenero;
		duracion = pDuracion;
		director = pDirector;
	}

	public String darNombre() {
		return nombre;
	}

	public String darGenero() {
		return genero;
	}

	public int darDuracion() {
		return duracion;
	}

	public String darDirector() {
		return director;
	}

	public void cambiarNombre(String pNombre) {
		nombre = pNombre;
	}

	public void cambiarGenero(String pGener) {
		genero = pGener;
	}

	public void cambiarDuracion(int pDuracion) {
		duracion = pDuracion;
	}

	public void cambiarDirector(String pDirector) {
		director = pDirector;
	}

	/**
	 * Retorna una cadena de texto con la información de la película siguiendo el
	 * siguiente formato: <nombre> (<genero>). <duracion> minutos - director.
	 * 
	 * @return La cadena de texto con el formato definido.
	 */
	public String toString() {
		return  nombre + " (" + genero + "). " + duracion + " minutos - " + director;
	}
}
