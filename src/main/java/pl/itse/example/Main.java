package pl.itse.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
* Simple example how to AOP in spring application
* 
* @author Borys Pawluczuk
*/

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		IUser service = context.getBean("user", User.class);

		System.out.println(service.getName());

		try {
			service.simulateException();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
}
