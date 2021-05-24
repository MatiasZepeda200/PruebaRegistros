package cl.inacap.rCivilModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.rCivilModel.dto.Registro;

/**
 * Session Bean implementation class RegistrosDAO
 */
@Stateless
@LocalBean
public class RegistrosDAO implements RegistrosDAOLocal {

	private static List<Registro> registros = new ArrayList<>();

	@Override
	public void save(Registro registro) {
		registros.add(registro);
	}

	@Override
	public List<Registro> getAll() {
		// TODO Auto-generated method stub
		return registros;
	}

	@Override
	public void deleted(Registro registro) {
		// TODO Auto-generated method stub
		registros.remove(registro);
	}

	@Override
	public List<Registro> filterByName(String solicitud) {
		// TODO Auto-generated method stub
		return registros.stream().filter(c->c.getSolicitud().contains(solicitud)).collect(Collectors.toList());
	}

}
