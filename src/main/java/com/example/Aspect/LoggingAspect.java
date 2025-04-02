package com.example.Aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger logger = Logger.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.example.service.*.*(..))")
	public void logBefore() {
		logger.info("📌 Service 메서드 실행 시작");
	}
	
	@AfterReturning("execution(* com.example.service.*.*(..))")
	public void logAfterReturning() {
		logger.info("☑️ Service 메서드 정상 완료");
	}
	
	@AfterThrowing(pointcut = "execution(* com.example.service.*.*(..))", throwing = "ex")
	public void logAfterThrowing(Exception ex) {
		logger.error("❌ Service 메서드 실행 중 오류 발생: " + ex.getMessage());
	}
}
