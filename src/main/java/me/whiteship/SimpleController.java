package me.whiteship;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DispatcherServlet 기능 중
 * handlerMapping의 BeanNameUrlHandlerMapping과
 * handlerAdapter의 SimpleControllerHandlerAdapter를 사용하여 Bean 이름으로 찾아 동작한다.
 */
@org.springframework.stereotype.Controller("/simple")
public class SimpleController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("simple");
    }
}
