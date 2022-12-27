package hello.core.beanfind;

import hello.core.order.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextBaseicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
}
