package es.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.spring.model.Tabla2;
import es.spring.persistence.hsql.Tabla2Mapper;
import es.spring.service.Tabla2Service;

@Service("tabla2Service")
@Transactional(value="transactionManagerHsql",readOnly = true, isolation = Isolation.READ_COMMITTED)
public class Tabla2ServiceImpl implements Tabla2Service {

	@Autowired
	private Tabla2Mapper mapper;

	@Transactional(value="transactionManagerHsql",readOnly = false, propagation = Propagation.REQUIRED)
	public void add(Tabla2 tabla, boolean exception) {
		mapper.insert(tabla);
		if(exception)
		{
			throw new RuntimeException("Error creado 2");
		}
	}

	public List<Tabla2> getAll() {
		return mapper.selectByExample();
	}

}
