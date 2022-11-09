package me.whiteship;

import javax.servlet.*;
import java.io.IOException;

/**
 * - 서블릿 필터
 *  1. 들어온 요청을 서블릿으로 보내고, 또 서블릿이 작성한 응답을 클라이언트로 보내기 전에 특별한 처리가 필요한 경우에 사용할 수 있다.
 *  2. 체인 형태의 구조
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter Init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Filter Destroy");
    }
}
