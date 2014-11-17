package es.spring.service;

import es.spring.model.Tabla1;
import es.spring.model.Tabla2;

public interface MultiTablaService {

	
	void saveOk(Tabla1 tabla1, Tabla2 tabla2);
	
	void saveKo(Tabla1 tabla1, Tabla2 tabla2);
	
}
