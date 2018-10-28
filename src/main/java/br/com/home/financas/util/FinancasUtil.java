package br.com.home.financas.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import exception.FinancasException;

public class FinancasUtil {
	
	public static final String MAIN_URL = "http://localhost:9080";

	public FinancasUtil() {}
	
	public static Map<String, Object> getErroRetorno(Errors errors) {
		List<Erro> erroList = new ArrayList<>();
		for (ObjectError e : errors.getAllErrors()) {
			Erro erro = new Erro();

			String campo = e.getCodes()[1];
			erro.setCampo(campo.substring(campo.indexOf('.') + 1));
			erro.setMensagem(e.getDefaultMessage());
			erroList.add(erro);
		}
		
		Map<String, Object> retorno = new HashMap<>();
		retorno.put("status", "erro");
		retorno.put("erros", erroList);
		return retorno;
	}

	public static Map<String, Object> getErroRetorno(FinancasException e) {
		Erro erro = new Erro();
		erro.setMensagem(e.getMessage());

		Map<String, Object> retorno = new HashMap<>();
		retorno.put("status", "erro");
		retorno.put("erro", erro);
		return retorno;
	}
	
	public static String lPad(Integer valor, char complemento, int tamanho) {
		return lPad(String.valueOf(valor), complemento, tamanho);
	}
	
	public static String lPad(String texto, char complemento, int tamanho) {
		StringBuilder retorno = new StringBuilder();
		for (int i = 0; i < tamanho - texto.length(); i++) {
			retorno.append(complemento);
		}
		
		return retorno.toString() + texto;
	}
}
