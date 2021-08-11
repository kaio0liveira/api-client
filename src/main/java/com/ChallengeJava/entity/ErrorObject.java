package com.ChallengeJava.entity;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ErrorObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoExcecao;
	private String mensagem;
	private Date date;
	

	
	public ErrorObject(String tipoExcecao, String mensagem) {
		super();
		this.tipoExcecao = tipoExcecao;
		this.mensagem = mensagem;
		this.date = new Date();
		
	}
	
	public String getTipoExcecao() {
		return tipoExcecao;
	}


	public String getMensagem() {
		return mensagem;
	}


	public Date getDate() {
		return date;
	}




	@Override
	public String toString() {
		return "ErrorObject [tipoExcecao=" + tipoExcecao + ", mensagem=" + mensagem + ", date=" + date + "]";
	}


	

	
	
	
}
