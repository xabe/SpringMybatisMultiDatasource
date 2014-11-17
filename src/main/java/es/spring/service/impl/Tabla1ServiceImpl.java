package es.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.spring.model.Tabla1;
import es.spring.persistence.h2.Tabla1Mapper;
import es.spring.service.Tabla1Service;

@Service("tabla1Service")
@Transactional(value="transactionManagerH2",readOnly = true, isolation = Isolation.READ_COMMITTED)
public class Tabla1ServiceImpl implements Tabla1Service {

	@Autowired
	private Tabla1Mapper mapper;

	@Transactional(value="transactionManagerH2",readOnly = false, propagation = Propagation.REQUIRED)
	public void add(Tabla1 tabla, boolean exception) {
		mapper.insert(tabla);
		if(exception)
		{
			throw new RuntimeException("Error creado 1");
		}
	}
	
	public List<Tabla1> getAll() {
		return mapper.selectByExample();
	}

}
