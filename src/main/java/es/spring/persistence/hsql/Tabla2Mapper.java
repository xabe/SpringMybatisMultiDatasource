package es.spring.persistence.hsql;

import java.util.List;

import es.spring.model.Tabla2;

public interface  Tabla2Mapper {
	
	List<Tabla2> selectByExample();
	
	int insert(Tabla2 tabla2);

}
