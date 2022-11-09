package me.whiteship;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * web.xml에서 설정하던 DispatcherServlet을 아래와 같이 자바 코드로 설정함!!
 *  1. WebApplicationInitializer에 자바 코드로 서블릿 등록 (스프링 3.1+, 서블릿 3.0+)
 *  2. 세부 구성 요소는 빈 설정하기 나름.
 *
 * - DispatcherServlet
 *  1. 스프링 MVC의 핵심.
 *  2. Front Controller 역할을 한다.
 *
 * - DispatcherServlet 동작 순서
 * 1. 요청을 분석한다. (로케일, 테마, 멀티파트 등)
 * 2. (핸들러 맵핑에게 위임하여) 요청을 처리할 핸들러를 찾는다. -> HandlerMapping.ReuqestMappingHandlerMapping
 * 3. (등록되어 있는 핸들러 어댑터 중에) 해당 핸들러를 실행할 수 있는 “핸들러어댑터”를 찾는다. -> HandlerAdapter
 * 4. 찾아낸 “핸들러 어댑터”를 사용해서 핸들러의 응답을 처리한다.
 * 	    ● 핸들러의 리턴값을 보고 어떻게 처리할지 판단한다.
 * 	    ● 뷰 이름에 해당하는 뷰를 찾아서 모델 데이터를 랜더링한다.
 * 	    ● @ResponseBody가 있다면 Converter를 사용해서 응답 본문을만들고.
 * 5. (부가적으로) 예외가 발생했다면, 예외 처리 핸들러에 요청 처리를 위임한다.
 * 6. 최종적으로 응답을 보낸다.
 */
public class WebApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setServletContext(servletContext);
        context.register(WebConfig.class);
        context.refresh();

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic app = servletContext.addServlet("app", dispatcherServlet);
        app.addMapping("/app/*");
    }
}
