package es.spring.persistence.h2;

import java.util.List;

import es.spring.model.Tabla1;

public interface  Tabla1Mapper {
	
	List<Tabla1> selectByExample();
	
	int insert(Tabla1 tabla1);

}
