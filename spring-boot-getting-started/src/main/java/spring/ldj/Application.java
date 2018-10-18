package spring.ldj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.holoman.Holoman;


//Application.class가 속해 있는 spring.ldj패키지 안에 속해 있는 것들만 bean으로 등록 할 수 있다.
@SpringBootApplication
//@SpringBootConfiguration
//@ComponentScan
//@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    //ComponentScan을 통하여 먼저 bean이 등록 되기 때문에
    //EnableautoConfiguration때 다른 의존성에 있는 holoman bean이 등록 되면서 오버라이딩 된다.
    //자동설정을 할 때 순서를 생각하면서 bean을 등록하자
    //@ConditionalON~~을 통해서 조건을 만들어 아래의 bean을 사용 가능하게 할 수 있다.
//    @Bean
//    public Holoman holoman() {
//        Holoman holoman = new Holoman();
//        holoman.setName("dong");
//        holoman.setHowLong(13);
//        return holoman;
//    }
}
