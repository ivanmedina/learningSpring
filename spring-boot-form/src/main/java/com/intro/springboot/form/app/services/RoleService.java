package com.intro.springboot.form.app.services;

import java.util.List;

import com.intro.springboot.form.app.models.domains.Role;

public interface RoleService {

	public List<Role> listar();
	public Role obtenerPorId(Integer id);
}
