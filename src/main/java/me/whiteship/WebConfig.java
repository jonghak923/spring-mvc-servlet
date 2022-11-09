package me.whiteship;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web.xml에서 viewResolvers 설정을 아래와 같이 자바로 설정함!!
 *
 * - DispatcherServlet 기능 중 ViewResolver 사용
 *  1. InternalResourceViewResolver
 *      ● Prefix
 *      ● Suffix
 */
@Configuration
@ComponentScan
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/", ".jsp");
    }

}
