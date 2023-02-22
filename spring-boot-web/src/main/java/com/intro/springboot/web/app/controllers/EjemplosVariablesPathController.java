package com.intro.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemplosVariablesPathController {
	
	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("titulo","Enviar parametros por el PATH(@PathVariable)");
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model){
		model.addAttribute("titulo","Recibir parametros por el PATH(@PathVariable)");
		model.addAttribute("resultado","El texto enviado por la ruta es: "+texto);
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto,@PathVariable String numero, Model model){
		model.addAttribute("titulo","Recibir parametros por el PATH(@PathVariable)");
		model.addAttribute("resultado","El texto enviado por la ruta es: "+texto+
				" y el numero es "+ numero);
		return "variables/ver";
	}
}
