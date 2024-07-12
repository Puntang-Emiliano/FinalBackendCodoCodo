package ar.com.CodoCodo;

public class Pelicula 
{
	private int id; 
	private String titulo;
	private String genero;
	private String duracion;
	private String director;	
	private String sinopsis;
	private String imagen;
	private String fecha_lanzamiento; 
	
	
	public Pelicula(int id, String titulo, String genero, String duracion, String director,
			String sinopsis, String imagen) 
	{		
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
		this.director = director;	
		this.sinopsis = sinopsis;
		this.imagen = imagen;
	}
	
	public Pelicula() 
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}



	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	 public String getFechaLanzamiento() {
	        return fecha_lanzamiento;
	    }

	    public void setFechaLanzamiento(String fecha_lanzamiento) {
	        this.fecha_lanzamiento = fecha_lanzamiento;
	    }
	
	
	
	

}
