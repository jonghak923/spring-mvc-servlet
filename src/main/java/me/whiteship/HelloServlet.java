package me.whiteship;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * - 서블릿 (Servlet)
 *  1. 자바 엔터프라이즈 에디션은 웹 애플리케이션 개발용 스팩과 API 제공.
 *  2. 요청 당 쓰레드 (만들거나, 풀에서 가져다가) 사용
 *  3. 그 중에 가장 중요한 클래스중 하나가 HttpServlet.
 *
 * - 서블릿 생명주기
 *  1. 서블릿 컨테이너가 서블릿 인스턴스의 init() 메소드를 호출하여 초기화 한다.
 *  2. 최초 요청을 받았을 때 한번 초기화 하고 나면 그 다음 요청부터는 이 과정을 생략한다.
 *  3. 서블릿이 초기화 된 다음부터 클라이언트의 요청을 처리할 수 있다. 각 요청은 별도의 쓰레드로 처리하고 이때 서블릿 인스턴스의 service() 메소드를 호출한다.
 *  4. 이 안에서 HTTP 요청을 받고 클라이언트로 보낼 HTTP 응답을 만든다.
 *  5. service()는 보통 HTTP Method에 따라 doGet(), doPost() 등으로 처리를 위임한다.
 *  6. 따라서 보통 doGet() 또는 doPost()를 구현한다.
 *  7. 서블릿 컨테이너 판단에 따라 해당 서블릿을 메모리에서 내려야 할 시점에 destroy()를 호출한다. (tomcat에 shutdown 되는 시점)
 */
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");

        ApplicationContext context = (ApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        HelloService helloService = context.getBean(HelloService.class);
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h1>Hello, " + helloService.getName() + "</h1>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("</html>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
