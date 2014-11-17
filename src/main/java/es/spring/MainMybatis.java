package es.spring;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.spring.model.Tabla1;
import es.spring.model.Tabla2;
import es.spring.service.MultiTablaService;
import es.spring.service.Tabla1Service;
import es.spring.service.Tabla2Service;

public class MainMybatis {
	private static final Logger LOGGER = LoggerFactory.getLogger(MainMybatis.class);

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
		Tabla1Service tabla1Service = context.getBean(Tabla1Service.class);
		Tabla2Service tabla2Service = context.getBean(Tabla2Service.class);
		MultiTablaService multiTablaService = context.getBean(MultiTablaService.class);
		
		LOGGER.info("---------- Contenido de las tablas ---------------------");
		vertablas(tabla1Service, tabla2Service);
		
		try
		{
			Tabla1 tabla1 = new Tabla1();
			tabla1.setNombre("tabla1");
			tabla1.setFecha(new Date());
			
			Tabla2 tabla2 = new Tabla2();
			tabla2.setId(20);
			tabla2.setNombre("tabla2");
			tabla2.setFecha(new Date());
			
			LOGGER.info("---------- Insertamos en la tabla 1 y tabla 2 sin excepcion ---------------------");	
			
			multiTablaService.saveOk(tabla1, tabla2);
			
			
			tabla1 = new Tabla1();
			tabla1.setNombre("tabla1.1");
			tabla1.setFecha(new Date());
			
			tabla2 = new Tabla2();
			tabla2.setId(40);
			tabla2.setNombre("tabla2.1");
			tabla2.setFecha(new Date());
			
			LOGGER.info("---------- Insertamos en la tabla 1  sin excepcion y tabla 2 con exception ---------------------");	
			
			multiTablaService.saveKo(tabla1, tabla2);
			
				
			
			
			
		}catch(Exception e){ 
			LOGGER.error(e.getMessage(),e);
		}
		
		
		LOGGER.info("---------- Contenido de las tablas despues de las inserciones ---------------------");
		vertablas(tabla1Service, tabla2Service);
		
		context.close();
	}

	private static void vertablas(Tabla1Service tabla1Service, Tabla2Service tabla2Service){
		verTabla(tabla1Service.getAll()," 1");
		verTabla(tabla2Service.getAll()," 2");
	}
	
	private static void verTabla(List<?> list,String name) {
		LOGGER.info("----------Inicio del contenido de la tabla "+name+"---------------------");
		for (Object object : list) {
			LOGGER.info(object.toString());
		}
		LOGGER.info("----------Fin del contenido de la tabla "+name+"---------------------");
	}

}