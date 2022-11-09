package me.whiteship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RestController는 @Controller에서 함수마다 @ResponseBody를 추가해 준 것과 같다!!!
 */
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    /**
     * DispatcherServlet 기능 중
     * handlerMapping의 ReuqestMappingHandlerMapping과
     * handlerAdapter의 RequestMappinghandlerAdapter 사용하여 어노테이션 설정 방식으로 동작함!!
     * @return
     */
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, " + helloService.getName();
    }

    /**
     * DispatcherServlet 기능 중 RequestToViewNameTranslator 테스트
     *  핸들러에서 뷰 이름을 명시적으로 리턴하지 않은 경우, 요청을 기반(url)으로 뷰 이름을 판단
     */
    @GetMapping("/sample")
    public void sample() {}

}
