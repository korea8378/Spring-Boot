package ldj.springboot.springapplication;


import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class SpringinitApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringinitApplication.class);
//        app.setBannerMode(Banner.Mode.OFF); 배너 설정
//        app.addListeners(new SampleListener()); 이벤트 직접 등록
//        app.setWebApplicationType(WebApplicationType.REACTIVE);//webflux를 사용할 경우
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);


//        //builder를 이용해서 사용
//        new SpringApplicationBuilder()
//                .sources(SpringinitApplication.class)
//                .run(args);
    }
}
