package com.example.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	public GlobalExceptionHandler() {
	    logger.info("✅ GlobalExceptionHandler 초기화 완료!");
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handlerNotFound(Exception ex, HttpServletRequest request, Model model) {
		logger.warn("❌ 404 Not Found: {}", request.getRequestURL());
	    model.addAttribute("errorMessage", "페이지를 찾을 수 없습니다.");
	    return "error/error404";
	}
	
	@ExceptionHandler(Exception.class)
    public String handleGeneralException(HttpServletRequest request, Exception ex, Model model) {
        logger.error("🚨 예외 발생: {} → {}", ex.getClass().getSimpleName(), request.getRequestURL());
        model.addAttribute("errorMessage", "서버 내부 오류가 발생했습니다.");
        return "error/error500";
    }
}