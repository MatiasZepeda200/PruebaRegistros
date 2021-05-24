package cl.inacap.rCivilApp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.rCivilModel.dao.RegistrosDAOLocal;
import cl.inacap.rCivilModel.dto.Registro;

/**
 * Servlet implementation class AgregarRegistroController
 */
@WebServlet("/AgregarRegistroController.do")
public class AgregarRegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 int number = 1;
	@Inject
	private RegistrosDAOLocal registrosDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarRegistroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/vistas/agregarRegistro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> errores = new ArrayList<>();

		String rut = request.getParameter("rut-txt").trim();

		String letra, subRut, finale = "i";
		int contador = 2, suma = 0, rutAux = 0, x = 0, division = 0, resultado = 0;


		if (rut.isEmpty()) {
			errores.add("Ingrese un rut");
		}else {
			letra = rut.substring(11, 12);
			for (int i = 10; i > 0;) {
				try {
					subRut = rut.substring(i - 1, i);
					rutAux = Integer.parseInt(subRut);
					if (contador == 8) {
						contador = 2;
						x = rutAux * contador;
						suma = suma + x;
						contador = contador + 1;
						i = i - 1;
					} else {
						x = rutAux * contador;
						suma = suma + x;
						contador = contador + 1;
						i = i - 1;
					}
				} catch (Exception e) {
					i = i - 1;
				}
			}
			division = suma % 11;
			resultado = 11 - division;
			if (resultado == 11 || resultado == 10) {
				if (resultado == 10) {
					finale = "0";
				} else if (resultado != 10) {
					finale.equals(letra);
				}
			} else {
				finale = Integer.toString(resultado);
			}

			if (finale.equals(letra)) {

			} else {
				errores.add("El rut no existe");
			}
		}
		
		String nombre = request.getParameter("nombre-txt").trim();
		if (nombre.isEmpty()) {
			errores.add("Debe Ingresar un nombre");
		}
		String tipoSolicitud = request.getParameter("tipo-select").trim();
		if (tipoSolicitud.isEmpty()) {
			errores.add("Ingrese una Solicitud");
		}
		 int numero = 0;
		 if (tipoSolicitud == "Retiro de Cedula de Identidad") {
			 String originalTxt = request.getParameter("original-txt").trim();
			 try {
					numero=Integer.parseInt(originalTxt);
				} catch (Exception ex) {
					errores.add("Ingrese un valor numerico");
				}
		}
		AtomicInteger get = new AtomicInteger();
			 get = new AtomicInteger(number);
		 
		if (errores.isEmpty()) {
			Registro registro = new Registro();
			registro.setNombre(nombre);
			registro.setRut(rut);
			registro.setSolicitud(tipoSolicitud);
			registro.setNumeroSolicitud(get.getAndIncrement());
			registro.setNumeroOriginal(numero);
			registrosDAO.save(registro);
			RequestDispatcher rd;
			rd=request.getRequestDispatcher("VerRegistroControllers.do");
			rd.forward(request, response);
			number = number+1;
		}else {
			request.setAttribute("errores", errores);
		}
		
		doGet(request, response);
	}

}
