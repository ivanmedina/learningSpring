package com.intro.springboot.horariointercept.app.interceptors;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("horario")
public class HorarioInterceptor implements HandlerInterceptor{

	
	private Integer apertura=12;
	
	private Integer cierre=13;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Calendar calendar = Calendar.getInstance();
		int hora = calendar.get(Calendar.HOUR_OF_DAY);
		if(hora >= apertura && hora < cierre) {
			StringBuilder mensaje = new StringBuilder("Bienvenido al horario de atencion");
			mensaje.append(", atendemos desde las");
			mensaje.append(apertura);
			mensaje.append(" hasta las ");
			mensaje.append(cierre);
			mensaje.append(" Gracias por su visita");request.setAttribute("mensaje", mensaje.toString());
			return true;
		}
		response.sendRedirect(request.getContextPath().concat("/cerrado"));
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String mensaje = (String) request.getAttribute("mensaje");
		if(modelAndView!=null) {
			modelAndView.addObject("horario",mensaje);			
		}
	}

}
 