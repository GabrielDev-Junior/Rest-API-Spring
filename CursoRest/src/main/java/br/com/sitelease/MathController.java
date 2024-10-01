package br.com.sitelease;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sitelease.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MathController {

	
	private final AtomicLong count = new AtomicLong();
	
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo ) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Prease set s numeric value!");
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replace(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	@RequestMapping("/{param}/{numberOne}/{numberTwo}")
	public Double maths(@PathVariable(value = "param") String param,@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo ) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Prease set s numeric value!");
		}
		switch (param) {
		case "sub": {
			return convertToDouble(numberOne) - convertToDouble(numberTwo); 
		}
		case "mult":{
			return convertToDouble(numberOne) * convertToDouble(numberTwo); 
		}
		case "div":{
			return convertToDouble(numberOne) / convertToDouble(numberTwo); 
		}
		case "med":{
			return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
		}
		case "raiz":{
			Double total = convertToDouble(numberOne) + convertToDouble(numberTwo); 
			return Math.sqrt(total);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + param);
		}
	}
}
