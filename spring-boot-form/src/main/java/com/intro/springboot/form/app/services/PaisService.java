package com.intro.springboot.form.app.services;

import java.util.List;

import com.intro.springboot.form.app.models.domains.Pais;

public interface PaisService {
	public List<Pais> listar();
	public Pais obtenerPorId(Integer id);
}
