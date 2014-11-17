package es.spring.service;

import java.util.List;

import es.spring.model.Tabla1;


public interface Tabla1Service {

	void add(Tabla1 tabla, boolean exception);

	List<Tabla1> getAll();

}
