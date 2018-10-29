package ldj.springboot.springapplication;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


//ApplicationContext가 만들어지기전에 발생하는 event
//@Component bean으로 등록 해봤자 applicationContext가 만들어지기전에 event가 발생하고 난뒤 bean으로 등록하기 때문에 직접 event를 추가해줘야한다.
//public class SampleListener implements ApplicationListener<ApplicationStartingEvent> {
//    @Override
//    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
//        System.out.println("========================");
//        System.out.println("Application is starting");
//        System.out.println("========================");
//    }
//}

//ApplicationContext가 만들어진 후 발생하는 event
//ApplicationContext에 bean으로 등록되고 난후 발생하기때문에 직접 event를 등록 해줄 필요가 없다.
//@Component
//public class SampleListener implements ApplicationListener<ApplicationStartedEvent> {
//    @Override
//    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
//        System.out.println("========================");
//        System.out.println("Application is starting");
//        System.out.println("========================");
//
//    }

@Component
@Order(1) //우선 순위를 지정 할 수 있다.
public class SampleListener implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("foo : " + args.containsOption("foo"));
        System.out.println("bar : " + args.containsOption("bar"));
    }

    //class에 생성자가 하나이고 매개변수가 bean일 경우 springApplication이 알아서 bean을 주입해준다.
//    public SampleListener(ApplicationArguments applicationArguments) {
//        System.out.println("foo : " + applicationArguments.containsOption("foo"));
//        System.out.println("bar : " + applicationArguments.containsOption("bar"));
//    }


}