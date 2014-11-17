package es.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.spring.model.Tabla1;
import es.spring.model.Tabla2;
import es.spring.service.MultiTablaService;
import es.spring.service.Tabla1Service;
import es.spring.service.Tabla2Service;
import es.spring.service.tx.H2Tx;
import es.spring.service.tx.HsqlTx;

@Service("multiTablaService")
@Transactional
public class MultiTablaServiceImpl implements MultiTablaService {
	
	@Autowired
	private Tabla1Service tabla1Service;
	@Autowired
	private Tabla2Service tabla2Service;
	
	@H2Tx
	@HsqlTx
	public void saveOk(Tabla1 tabla1, Tabla2 tabla2) {
		tabla1Service.add(tabla1, false);
		tabla2Service.add(tabla2, false);
	} 
	
	@H2Tx
	@HsqlTx
	public void saveKo(Tabla1 tabla1, Tabla2 tabla2) {
		tabla1Service.add(tabla1, false);
		tabla2Service.add(tabla2, true);		
	}

}
