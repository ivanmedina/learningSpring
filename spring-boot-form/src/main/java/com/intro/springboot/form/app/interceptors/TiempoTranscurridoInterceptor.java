package com.intro.springboot.form.app.interceptors;

import java.util.Random;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor{

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("post")){
			return true;
		}
		
		if(handler instanceof HandlerMethod) {
			HandlerMethod metodo = (HandlerMethod) handler;
			logger.info("es un metodo del controlador:"+metodo.getMethod().getName());
		}
		logger.info("TiempoTranscurridoInterceptor: preHandle() entrando...");
		long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		Random random = new Random();
		Integer demora = random.nextInt(500);
		Thread.sleep(demora);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("post")){
			return;
		}
		
		long tiempoFin = System.currentTimeMillis();
		long tiempoInicio = (Long)request.getAttribute("tiempoInicio"); 
		long tiempoTranscurrido = tiempoFin - tiempoInicio;
		
		if(handler instanceof HandlerMethod && modelAndView != null) {
			modelAndView.addObject("tiempoTranscurrido",tiempoTranscurrido);
		}
		logger.info("Tiempo Transcurrido: "+tiempoTranscurrido+" ms.");
		logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo...");
	}

}
 