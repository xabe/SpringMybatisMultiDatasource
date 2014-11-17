package es.spring.service;

import java.util.List;

import es.spring.model.Tabla2;


public interface Tabla2Service {

	void add(Tabla2 tabla, boolean exception);

	List<Tabla2> getAll();

}
