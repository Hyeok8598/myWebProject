package com.example.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring MVC 초기 설정 담당 클래스.
 * web.xml 대체하는 역할 수행
 * Spring 실행 시, DispatcherSevlet 등록, 설정 파일 로드 기능 수행
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class}; // 모든 설정을 AppConfig에서 로드
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	super.onStartup(servletContext);
    	
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        
        ServletRegistration.Dynamic dispatcher = (ServletRegistration.Dynamic)servletContext.getServletRegistration("dispatcher");
        
        // DispatcherServlet을 서블릿 컨텍스트에 추가
        if(dispatcher == null) {
        	dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet());
        	dispatcher.setLoadOnStartup(1);
            dispatcher.addMapping("/");
            dispatcher.setInitParameter("throwExceptionIfNoHandlerFound", "true");
        }
        else {
        	dispatcher.setInitParameter("throwExceptionIfNoHandlerFound", "true");
        }   
    }
}