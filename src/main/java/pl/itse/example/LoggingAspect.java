package pl.itse.example;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//Spring AOP AspectJ

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = Logger.getLogger(LoggingAspect.class);

	@Before("execution (* pl.itse.example.*.*(..)) || @annotation(pl.itse.example.Log)")
	public void beforeAdvice(JoinPoint joinPoint) {

		logger.info("Before method: " + joinPoint.toString());
	}

	@After("execution (* pl.itse.example.*.*(..)) || @annotation(pl.itse.example.Log)")
	public void afterAdvice(JoinPoint joinPoint) {

		logger.info("After method: " + joinPoint.toString());
	}

	@AfterReturning("execution (* pl.itse.example.*.*(..)) || @annotation(pl.itse.example.Log)")
	public void afterReturningAdvice(JoinPoint joinPoint) {

		logger.info("After returning: " + joinPoint.toString());
	}

	@AfterThrowing("execution (* pl.itse.example.*.*(..)) || @annotation(pl.itse.example.Log)")
	public void afterThrowingAdvice(JoinPoint joinPoint) {

		logger.info("After exception thrown: " + joinPoint.toString());
	}
	
	@Around("execution (* pl.itse.example.*.*(..)) || @annotation(pl.itse.example.Log)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{

		logger.info("Around: " + joinPoint.toString());
		return joinPoint.proceed();
	}

}
