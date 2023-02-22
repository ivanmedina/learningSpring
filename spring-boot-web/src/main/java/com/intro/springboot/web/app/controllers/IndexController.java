package com.intro.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intro.springboot.web.app.models.Usuario;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;

	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model){
		model.addAttribute("titulo",textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model){
		Usuario usuario = new Usuario();
		usuario.setNombre("Ivan");
		usuario.setApellido("Medina");
		usuario.setEmail("ivan@correo.com");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model){
		model.addAttribute("titulo",textoListar);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Ivan","Medina","ivan@correo.com"));
		usuarios.add(new Usuario("Experto","Profesional","experto@correo.com"));
		usuarios.add(new Usuario("Maria","Luisa","maria@correo.com"));
		return usuarios;
	}
}
