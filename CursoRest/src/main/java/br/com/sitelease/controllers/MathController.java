package br.com.sitelease.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sitelease.converters.NumberConverters;
import br.com.sitelease.exceptions.UnsupportedMathOperationException;
import br.com.sitelease.math.SimpleMath;


@RestController
public class MathController {

	private SimpleMath math = new SimpleMath();
	private final AtomicLong count = new AtomicLong();

	@RequestMapping("/{param}/{numberOne}/{numberTwo}")
	public Double maths(@PathVariable(value = "param") String param,@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo ) throws Exception {
		if(!NumberConverters.isNumeric(numberOne) || !NumberConverters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Prease set s numeric value!");
		}
		switch (param) {			
		case "sum":{
			return math.sum(NumberConverters.convertToDouble(numberOne), NumberConverters.convertToDouble(numberTwo));
		}
		case "sub": {
			return math.sub(NumberConverters.convertToDouble(numberOne), NumberConverters.convertToDouble(numberTwo)); 
		}
		case "mult":{
			return math.mult(NumberConverters.convertToDouble(numberOne), NumberConverters.convertToDouble(numberTwo)); 
		}
		case "div":{
			return math.div(NumberConverters.convertToDouble(numberOne), NumberConverters.convertToDouble(numberTwo)); 
		}
		case "med":{
			return math.media(NumberConverters.convertToDouble(numberOne), NumberConverters.convertToDouble(numberTwo));
		}
		case "raiz":{
			return math.raiz(NumberConverters.convertToDouble(numberOne), NumberConverters.convertToDouble(numberTwo));
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + param);					
		}
	}
}
