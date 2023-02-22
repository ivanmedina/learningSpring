package com.intro.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.intro.springboot.form.app.editors.NombreMayusculaEditor;
import com.intro.springboot.form.app.editors.PaisPropertyEditor;
import com.intro.springboot.form.app.editors.RolesEditor;
import com.intro.springboot.form.app.models.domains.Pais;
import com.intro.springboot.form.app.models.domains.Role;
import com.intro.springboot.form.app.models.domains.Usuario;
import com.intro.springboot.form.app.services.PaisService;
import com.intro.springboot.form.app.services.RoleService;
import com.intro.springboot.form.app.validation.UsuarioValidator;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidator validator;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private PaisPropertyEditor paisEditor;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RolesEditor roleEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		dateformat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateformat,false));
		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());
		
		binder.registerCustomEditor(Pais.class,"pais", paisEditor);
		binder.registerCustomEditor(Role.class, "roles",roleEditor);
	}
	
	
	@GetMapping("/form")
	public String form(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("John");
		usuario.setApellido("Doe");
		usuario.setIdentificador("12.456.789-K");
		usuario.setHabilitar(true);
		usuario.setValorSecreto("0xDEADBEEF");
		usuario.setPais(new Pais(3,"CL","Chile"));
//		usuario.setRoles(Arrays.asList(new Role(2,"Usuario", "ROLE_USER")));
		model.addAttribute("titulo","Formulario Usuarios");
		model.addAttribute("usuario",usuario);
		return "forms";
	}
	
	@ModelAttribute("genero")
	public List<String>genero(){
		return Arrays.asList("Hombre","Mujer");
	}
	
	@ModelAttribute("listaRoles")
	public List<Role> listaRoles(){
		return this.roleService.listar();
	}

	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString(){
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}
	
	@ModelAttribute("rolesMap")
	public Map<String, String> listaRolesMap(){
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN","Administrador");
		roles.put("ROLE_USER","Usuario");
		roles.put("ROLE_MODERATOR","Moderador");
		return roles;
	}
	
	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises(){
		return paisService.listar();
	}
	
	@ModelAttribute("paises")
	public List<String> paises(){
		return Arrays.asList("Mexico","Panama","Colombia","Peru");
	}
	
	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap(){
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("ES","España");
		paises.put("MX","Mexico");
		paises.put("CO","Colombia");
		paises.put("AR","Argentina");
		return paises;
	}
	
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {

		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Resultado");
			return "forms";
		}
		return "redirect:/ver";			
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name = "usuario", required=false) Usuario usuario, Model model, SessionStatus status){
		if(usuario==null) {
			return "redirect:/form";
		}
		model.addAttribute("titulo", "Resultado");
		status.setComplete();
		return "resultado";
	}
	
}
