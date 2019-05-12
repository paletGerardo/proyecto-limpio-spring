package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Pais;

import java.util.List;

public interface PaisDao {

    public void guardarPaises(List<Pais> lista);
    public List<Pais> buscarPaisesPor(String criterio);
}
