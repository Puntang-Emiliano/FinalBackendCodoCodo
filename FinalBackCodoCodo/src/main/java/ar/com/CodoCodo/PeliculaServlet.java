package ar.com.CodoCodo;

import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



@WebServlet("/peliculas/*")
public class PeliculaServlet extends HttpServlet 
{

	
	private PeliculaService peliculaService;
	private ObjectMapper objectMapper;
	
	 @Override
	    public void init() throws ServletException 
	    {
	        peliculaService = new PeliculaService();
	        objectMapper = new ObjectMapper();
	    }
	 
	 
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	    {
	        String pathInfo = req.getPathInfo();
	        try {
	            if (pathInfo == null || pathInfo.equals("/")) 
	            {
	                List<Pelicula> peliculas = peliculaService.getAllpeliculas();
	                String json = objectMapper.writeValueAsString(peliculas);
	                resp.setContentType("application/json");
	                resp.getWriter().write(json);
	            } 
	            else 
	            {
	                String[] pathParts = pathInfo.split("/");
	                int id = Integer.parseInt(pathParts[1]);
	                Pelicula pelicula = peliculaService.getAllpeliculaById(id);
	                if (pelicula != null) 
	                {
	                    String json = objectMapper.writeValueAsString(pelicula);
	                    resp.setContentType("application/json");
	                    resp.getWriter().write(json);
	                } 
	                else 
	                {
	                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	                }
	            }
	        } 
	        catch (SQLException | ClassNotFoundException e) 
	        {
	            throw new ServletException(e);
	        }
	    }
	 
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	    {
	        try 
	        {
	            Pelicula pelicula = objectMapper.readValue(req.getReader(), Pelicula.class);
	            peliculaService.addPelicula(pelicula);
	            resp.setStatus(HttpServletResponse.SC_CREATED);
	        } 
	        catch (SQLException | ClassNotFoundException e) 
	        {
	            throw new ServletException(e);
	        }
	    }
       
	   @Override
	    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	    {
	        try 
	        {
	            Pelicula pelicula = objectMapper.readValue(req.getReader(), Pelicula.class);
	            peliculaService.updatepelicula(pelicula);
	            resp.setStatus(HttpServletResponse.SC_OK);
	        } 
	        catch (SQLException | ClassNotFoundException e) 
	        {
	            throw new ServletException(e);
	        }
	    }
	   
	   @Override
	    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	    {
	        String pathInfo = req.getPathInfo();
	        try {
	            	if (pathInfo != null && pathInfo.split("/").length > 1) 
	            	{
		                int id = Integer.parseInt(pathInfo.split("/")[1]);
		                peliculaService.deletepelicula(id);
		                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
	            	} 
	            	else 
	            	{
	            		resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
	            	}
	        	} 
	        	catch (SQLException | ClassNotFoundException e) 
	        	{
	        			throw new ServletException(e);
	        	}
	    }
   

}
