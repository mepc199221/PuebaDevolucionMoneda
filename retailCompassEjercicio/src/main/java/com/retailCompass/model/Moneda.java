package com.retailCompass.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data @ToString() @EqualsAndHashCode(callSuper=false)
public class Moneda {
	
	private String tipo;  
	private String valor;
	
}
