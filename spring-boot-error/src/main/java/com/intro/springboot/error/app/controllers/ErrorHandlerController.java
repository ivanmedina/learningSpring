package com.intro.springboot.error.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.intro.springboot.error.app.errors.UsuarioNoEncontradoException;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(ArithmeticException.class)
	public String aritmeticaError(Exception ex, Model model){
		model.addAttribute("error","Error de aritmetica");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/aritmetica";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatError(NumberFormatException ex, Model model){
		model.addAttribute("error","Error de formato de numero");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/numberformat";
	}
	
	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public String usuarioNoEncontrado(UsuarioNoEncontradoException ex, Model model){
		model.addAttribute("error","Error: Usuario no encontrado");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/generica";
	}
}
