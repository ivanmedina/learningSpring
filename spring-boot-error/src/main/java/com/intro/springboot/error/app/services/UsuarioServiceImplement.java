package com.intro.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.intro.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImplement implements UsuarioService{
	
	private List<Usuario> lista;
	
	public UsuarioServiceImplement() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1,"Ivan","Medina"));
		this.lista.add(new Usuario(2,"Mc","Lovin"));
		this.lista.add(new Usuario(3,"Henrry","Danger"));
		this.lista.add(new Usuario(4,"Tony","Stark"));
	}

	@Override
	public List<Usuario> listar(){
		return this.lista;
	}
	
	@Override
	public Usuario obtenerPorId(Integer id){
		Usuario resultado = null;
		for(Usuario u: this.lista) {
			if(u.getId().equals(id)) {
				resultado = u;
				break;
			}
		}
		return resultado;
	}
	
	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}

}
