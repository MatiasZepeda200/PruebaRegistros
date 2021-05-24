package cl.inacap.rCivilModel.dto;

public class Registro {

	private String rut;
	private String nombre;
	private int numeroSolicitud;
	private String solicitud;
	private int numeroOriginal;
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(int numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	public String getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}
	public int getNumeroOriginal() {
		return numeroOriginal;
	}
	public void setNumeroOriginal(int numeroOriginal) {
		this.numeroOriginal = numeroOriginal;
	}
	
}
