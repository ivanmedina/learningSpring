package com.intro.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.intro.springboot.form.app.models.domains.Pais;

@Service
public class PaisServiceImplement implements PaisService {

	private List<Pais> lista;
	
	public PaisServiceImplement() {
		this.lista = Arrays.asList(
				new Pais(1,"MX","Mexico"),
				new Pais(2,"PA","Panama"),
				new Pais(3,"CO","Colombia"),
				new Pais(4,"PE","Peru")
			);
	}

	@Override
	public List<Pais> listar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Pais resultado = null;
		for (Pais pais: this.lista)
			if(id == pais.getId()){
				resultado = pais;
				break;
			}
		return resultado;
	}

}
