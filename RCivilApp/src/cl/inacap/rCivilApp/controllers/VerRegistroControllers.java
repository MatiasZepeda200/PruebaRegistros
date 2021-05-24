package cl.inacap.rCivilApp.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.rCivilModel.dao.RegistrosDAOLocal;
import cl.inacap.rCivilModel.dto.Registro;

/**
 * Servlet implementation class VerRegistroControllers
 */
@WebServlet("/VerRegistroControllers.do")
public class VerRegistroControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private RegistrosDAOLocal registrosDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerRegistroControllers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Registro> registros = registrosDAO.getAll();
		
		if (request.getParameter("nombreEliminar") != null) {
			String nombre = request.getParameter("nombreEliminar").trim();
			List<Registro> busqueda = registrosDAO.filterByName(nombre);
			Registro registroAEliminar = busqueda.isEmpty()? null:busqueda.get(0);
			if (registroAEliminar != null) {
				registrosDAO.deleted(registroAEliminar);
			}
		}
		
		request.setAttribute("registros", registros);
		
		request.getRequestDispatcher("WEB-INF/vistas/verRegistro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
