package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@Component 붙은 클래스를 다 찾아서 Spring Bean으로 등록해줌, 이전에 만들었던 AppConfig 같은 예제들은 스캔되면 안되므로 제외
@ComponentScan(
    basePackages = "hello.core", //지정 안하면 default는 @ComponetScan을 붙인 class의 package(여기선 hello.core)부터 시작한다
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}