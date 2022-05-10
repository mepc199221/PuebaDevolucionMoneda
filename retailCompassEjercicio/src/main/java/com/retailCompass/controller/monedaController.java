package com.retailCompass.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.retailCompass.model.Moneda;
import com.retailCompass.utils.utils;

@RestController
@RequestMapping(value = "/moneda")
public class monedaController {
		
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody Moneda moneda){
		
		Moneda monedaResponse = new Moneda();	
		String reponseCambio = utils.cambio(moneda.getValor(),moneda.getTipo());
		
		//TODO:respuesta en consola
		System.out.println(reponseCambio.substring(0, reponseCambio.length()-3));
		
		//TODO:respuesta del objeto
		monedaResponse.setTipo(moneda.getTipo());
		monedaResponse.setValor(reponseCambio.substring(0, reponseCambio.length()-3));
		
		
		//TODO:respuesta del servicio
		ResponseEntity<Object> response;	
		response = new ResponseEntity<Object>(monedaResponse,HttpStatus.OK);	
		return response;
		
	}

}

