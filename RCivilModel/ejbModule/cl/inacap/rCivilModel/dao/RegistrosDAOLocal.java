package cl.inacap.rCivilModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.rCivilModel.dto.Registro;


@Local
public interface RegistrosDAOLocal {

	void save(Registro registro);
	List<Registro> getAll();
	void deleted(Registro registro);
	List<Registro> filterByName(String solicitud);
}
