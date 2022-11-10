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
/**
 * @Configuration 어노테이션에 @EnableWebMvc 어노테이션을 붙여주면
 * 어노테이션 기반 Spring MVC를 사용할 때 편리하게 웹 MVC 기본 설정을 해줌
 *  1. handlerMapping의 order가 명시적으로 설정됨 (RequestMappingHandler(어노테이션)의 우선순위가 높음)
 *  2. handelrMapping의 interceptors가 2개가 기본으로 설정됨
 *      ● ConversionServiceExposingInterceptor
 *      ● ResourceUrlProviderExposingInterceptor
 *  3. handlerAdapter의 messageConverters의 4 -> 6개로 converter가 더 많이 설정됨 (xml, jackson 추가되면 더 늘어남)
 *
 *  * Spring boot의 모티브가 @EnableWebMvc에서 왔을 가능성이 높음???
 *  * WebMvcConfigurer는 스프링부트에서도 사용하기 때문에 알아두면 좋음
*/
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/", ".jsp");
    }

}
