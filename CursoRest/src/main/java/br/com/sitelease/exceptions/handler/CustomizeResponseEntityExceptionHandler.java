package br.com.sitelease.exceptions.handler;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.sitelease.exceptions.ExceptionResponse;
import br.com.sitelease.exceptions.UnsupportedMathOperationException;

@ControllerAdvice // USADO SEMPRE QUE PRECISA CONCENTRAR ALGUM TRATAMENTO QUE SERIA ESPALHADO EM TODOS OS CONTROLES, TODA VEZ QUE QUALQUER CONTROLLER LANÇAR EXCEÇÃO ISSO SERÁ APLICADO
@RestController
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	// MÉTODO PARA TRATAMENTO PARA AS EXCEÇÕES MAIS GENERICAS DO JAVA ( EXCEPTION HANDLER )
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handlerAllException(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(0),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// EXCEÇÃO PARA TRATAR O ERRO DE O USUARIO DIGITAR LETRAS AO INVES DE NUMEROS NO PATHPARAMS, OU OUTRA REQUISIÇÃO INCORRETA
	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> handlerBadRequestException(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(0),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
