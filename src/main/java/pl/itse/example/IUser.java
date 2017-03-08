package pl.itse.example;

import org.springframework.stereotype.Component;

@Component
public interface IUser {
	
	public String getName();
	
	public void simulateException() throws Exception;

}
