package com.intro.springboot.error.app.errors;

public class UsuarioNoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioNoEncontradoException(String id) {
		super("El usuario con ID: ".concat(id).concat(" no existe en el sistema"));
	}

	
	
}
