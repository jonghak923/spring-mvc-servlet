package me.whiteship;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * - servlet listener (서블릿 리스너)
 *  1. 웹 애플리케이션에서 발생하는 주요 이벤트를 감지하고 각 이벤트에 특별한 작업이 필요한 경우에 사용할 수 있다.
 *  2. 서블릿 컨텍스트 수준의 이벤트
 *      ● 컨텍스트 라이프사이클 이벤트
 *      ● 컨텍스트 애트리뷰트 변경 이벤트
 *  3. 세션 수준의 이벤트
 *      ● 세션 라이프사이클 이벤트
 *      ● 세션 애트리뷰트 변경 이벤트
 */
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context Initialized");
        sce.getServletContext().setAttribute("name", "listener jonghak");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context Destroyed");
    }
}
