package br.com.sitelease;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	public final String tamplate = "Hallo, %s!";
	public AtomicLong count = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name) {
		return new Greeting(count.incrementAndGet(), String.format(tamplate, name));
	}
}
