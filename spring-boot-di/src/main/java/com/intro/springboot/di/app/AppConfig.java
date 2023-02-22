package com.intro.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.intro.springboot.di.app.models.domain.ItemFactura;
import com.intro.springboot.di.app.models.domain.Producto;
import com.intro.springboot.di.app.models.service.IServicio;
import com.intro.springboot.di.app.models.service.MiServicio;
import com.intro.springboot.di.app.models.service.MiServicioComplejo;

@Configuration
public class AppConfig {

	@Bean("miServicioSimple")
	public IServicio registrarMiServicio(){
		return new MiServicio();
	}
	
	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo(){
		return new MiServicioComplejo();
	}
	
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("RTX 4080",30000);
		Producto producto2 = new Producto("Memoria RAM DDR5 32 GB",10000);
		
		ItemFactura linea1 = new ItemFactura(producto1,2);
		ItemFactura linea2 = new ItemFactura(producto2,2);
		
		return Arrays.asList(linea1,linea2);
	}
	
	@Bean("itemsFacturaOficina")
	public List<ItemFactura> registrarItemsOficina(){
		Producto producto1 = new Producto("Monitor 49",300);
		Producto producto2 = new Producto("NoteBook Asus",100);
		Producto producto3 = new Producto("Impresora HP Multifuncional",100);
		Producto producto4 = new Producto("Escritorio Marmol",100);
		
		ItemFactura linea1 = new ItemFactura(producto1,9);
		ItemFactura linea2 = new ItemFactura(producto2,9);
		ItemFactura linea3 = new ItemFactura(producto3,3);
		ItemFactura linea4 = new ItemFactura(producto4,9);
		
		return Arrays.asList(linea1,linea2,linea3,linea4);
	}
}
