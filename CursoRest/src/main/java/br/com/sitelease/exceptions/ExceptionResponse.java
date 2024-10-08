package br.com.sitelease.exceptions;

import java.io.Serializable;
import java.sql.Date;

public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date timestemp; // A HORA EM QUE ACONTECEU O ERRO
	private String message; // A MENSAGEM DO ERRO 
	private String details; // OS DETALHES DO ERRO
	
	public ExceptionResponse(Date timestemp, String message, String details) {
		this.timestemp = timestemp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestemp() {
		return timestemp;
	}

	public void setTimestemp(Date timestemp) {
		this.timestemp = timestemp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
