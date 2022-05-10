package com.retailCompass.utils;

import java.util.HashMap;

public class utils {
	
	private static Integer valorMonedaInt;

	public static String cambio(String valorMoneda, String tipoMoneda) {
		
		String response = "";
		valorMonedaInt = Integer.parseInt(valorMoneda);		
		HashMap<String,Integer> listaMonedaCambio = listaMoneda(tipoMoneda);
		
		switch (tipoMoneda.toUpperCase()) {
		case "USD":		
			while (valorMonedaInt > 0) {			
				if(valorMonedaInt >= listaMonedaCambio.get("DOLLAR")) {	
					response = response + calcularCambio(listaMonedaCambio.get("DOLLAR"), "DOLLAR");
				
				}else if(valorMonedaInt < listaMonedaCambio.get("DOLLAR") && valorMonedaInt >= listaMonedaCambio.get("QUARTER")) {
					response = response + calcularCambio(listaMonedaCambio.get("QUARTER"), "QUARTER");
					
				}else if(valorMonedaInt < listaMonedaCambio.get("QUARTER") && valorMonedaInt >= listaMonedaCambio.get("DIME")) {	
					response = response + calcularCambio(listaMonedaCambio.get("DIME"), "DIME");
	
				}else if(valorMonedaInt < listaMonedaCambio.get("DIME") && valorMonedaInt >= listaMonedaCambio.get("NICKEL")) {
					response = response + calcularCambio(listaMonedaCambio.get("NICKEL"), "NICKEL");
	
				}else if(valorMonedaInt > 0 && valorMonedaInt < listaMonedaCambio.get("NICKEL")) {
					response = response + calcularCambio( listaMonedaCambio.get("CENTS"), "CENTS");
				
				}
			}
		
			break;
	
		default:
			break;
		}	
	

		return response;
	}
	
	public static HashMap<String,Integer> listaMoneda(String tipoMoneda) {
		
		HashMap<String,Integer> listaMoneda = new HashMap<String,Integer>();
		switch (tipoMoneda.toUpperCase()) {
		case "USD":
			//TODO: lista de monedas relacion Base a CENTS
			listaMoneda.put("DOLLAR",100);
			listaMoneda.put("QUARTER",25);
			listaMoneda.put("DIME",10);
			listaMoneda.put("NICKEL",5);
			listaMoneda.put("CENTS",1);
			break;

		default:
			break;
		}	
		
	return listaMoneda;
	}
	
	public static String calcularCambio(int valorEvaluar, String tipoMoneda) {
		
		Integer cantValorMonedaRes = 0;

		while (valorMonedaInt >= valorEvaluar) {			
			valorMonedaInt = valorMonedaInt - valorEvaluar;
			cantValorMonedaRes++;
		}
		
		return cantValorMonedaRes + " " + tipoMoneda + " | ";
	}
	
	
}
