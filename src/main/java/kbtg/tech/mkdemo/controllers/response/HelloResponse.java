package kbtg.tech.mkdemo.controllers.response;

public class HelloResponse {
	public String message;

	public HelloResponse(String message){
		//setMessage("Hello, "+message);
		setMessage(message);
	}
	
	public HelloResponse(){
		super();
	}

	public String getMessage() {
		//return "Hello, "+this.message;
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
