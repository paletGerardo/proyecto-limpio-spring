package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Ciudad;

import java.util.List;

public interface CiudadDao {
    Ciudad obtenerCiudad(Ciudad ciudad);
    List<Ciudad> obtenerTodas();
}
