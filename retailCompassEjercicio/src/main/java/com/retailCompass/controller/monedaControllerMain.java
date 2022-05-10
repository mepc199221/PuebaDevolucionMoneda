package com.retailCompass.controller;

import java.util.Scanner;

import com.retailCompass.utils.utils;

public class monedaControllerMain {
	public static void main(String[] args) {
		System.out.println("Escriba tipo de moneda:");
		Scanner TipoMoneda = new Scanner(System.in);
		String entradaTipoMoneda = TipoMoneda.next();
		
		if(!"USD".equals(entradaTipoMoneda.toUpperCase())) {
			System.out.println("No podemos procesar su solicitud");
		}else {
			
			System.out.println("Ingrese un monto en cents:");
			Scanner valor = new Scanner(System.in);
			String entradaValor = valor.next();
			
			String reponseCambio = utils.cambio(entradaValor,entradaTipoMoneda);
			System.out.println(reponseCambio.substring(0, reponseCambio.length()-3));
			
		}

	}

}
