package br.com.sitelease;

public class Greeting {

	private final long id;
	private final String template;
	
	
	public Greeting(long id, String template) {
		super();
		this.id = id;
		this.template = template;
	}
	
	public long getId() {
		return id;
	}
	
	public String getTemplate() {
		return template;
	}
	
	
}
