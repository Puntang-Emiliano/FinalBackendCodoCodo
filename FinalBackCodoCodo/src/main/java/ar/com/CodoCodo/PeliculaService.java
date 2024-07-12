package ar.com.CodoCodo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaService 
{
	private Conexion conexion;
	
	public PeliculaService() 
	{
		this.conexion = new Conexion(); 		
	}
	
	
	public List<Pelicula> getAllpeliculas() throws ClassNotFoundException, SQLException
	{
		List<Pelicula> peliculas = new ArrayList<>();
		
		Connection con= conexion.getConnection();
		String sql = "SELECT * FROM peliculas";
		PreparedStatement ps= con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) 
		{
			Pelicula pelicula = new Pelicula(
					rs.getInt("id"),
					rs.getString("titulo"),
					rs.getString("genero"),
					rs.getString("duracion"),
					rs.getString("director"),					
					rs.getString("sinopsis"),
					rs.getString("imagen"));
					rs.getString("fecha_lanzamiento");
			peliculas.add(pelicula);
		}
		rs.close();
		ps.close();
		return peliculas;		
	}
	
	public Pelicula getAllpeliculaById(int id) throws ClassNotFoundException, SQLException
	{
		Pelicula pelicula= null;
		Connection con= conexion.getConnection();
		String sql = "SELECT * FROM peliculas WHERE id = ?";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) 
		{
					pelicula = new Pelicula(
					rs.getInt("id"),
					rs.getString("titulo"),
					rs.getString("genero"),
					rs.getString("duracion"),
					rs.getString("director"),					
					rs.getString("sinopsis"),
					rs.getString("imagen"));	
					
		}
		rs.close();
		ps.close();
		return pelicula;	
		}
	
	public void addPelicula(Pelicula pelicula) throws ClassNotFoundException, SQLException {	
	    Connection con = conexion.getConnection();
	    String sql = "INSERT INTO peliculas (titulo, genero, duracion, director, sinopsis, imagen, fecha_lanzamiento) VALUES (?, ?, ?, ?, ?, ?,?)";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, pelicula.getTitulo());
	    ps.setString(2, pelicula.getGenero());
	    ps.setString(3, pelicula.getDuracion());
	    ps.setString(4, pelicula.getDirector());		
	    ps.setString(5, pelicula.getSinopsis());
	    ps.setString(6, pelicula.getImagen());
	    ps.setString(7, pelicula.getFechaLanzamiento());
	    ps.executeUpdate();
	    ps.close();
	    con.close();
	}
	
	
	
	public void updatepelicula(Pelicula pelicula) throws ClassNotFoundException, SQLException
	{   
	    Connection con = conexion.getConnection();
	    String sql = "UPDATE peliculas SET titulo = ?, genero = ?, duracion = ?, director = ?, sinopsis = ?, imagen = ?, fecha_lanzamiento = ? WHERE id = ?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, pelicula.getTitulo());      
	    ps.setString(2, pelicula.getGenero());
	    ps.setString(3, pelicula.getDuracion());
	    ps.setString(4, pelicula.getDirector());
	    ps.setString(5, pelicula.getSinopsis());
	    ps.setString(6, pelicula.getImagen());
	    ps.setString(7, pelicula.getFechaLanzamiento());
	    ps.setInt(8, pelicula.getId());
	    ps.executeUpdate();
	    ps.close();
	    con.close();
	}

		
		
	
	public void deletepelicula(int id) throws ClassNotFoundException, SQLException
	{
		Connection con= conexion.getConnection();
		String sql = "DELETE FROM peliculas WHERE id = ?";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	

}
