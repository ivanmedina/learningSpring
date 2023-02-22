package com.intro.springboot.horariointercept.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AppController {
	
	
	private Integer apertura = 14;
	
	private Integer cierre =18;

	@GetMapping({"/","/index"})
	public String index(Model model) {
		model.addAttribute ("titulo","Bienvenido al horario de atencion a clientes");
		return "index";
	}
	
	@GetMapping("/cerrado")
	public String cerrado(Model model){
		StringBuilder mensaje = new StringBuilder("Cerrado, por favor visitenos desde las ");
		mensaje.append(apertura);
		mensaje.append(" y las ");
		mensaje.append(cierre);
		mensaje.append(" hrs. Gracias");
		model.addAttribute("titulo", "Fuera del horario de atencion");
		model.addAttribute("mensaje",mensaje);
		return "cerrado";
	}
}
