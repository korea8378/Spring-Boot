package spring.holoman;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HolomanProperties.class)
public class HolomanConfiguration {

    @Bean
    @ConditionalOnMissingBean
    //EnableAutoConfiguration 할 때 이미 bean으로 등록 되어 있지 않다면 등록
    //등록되어 있다면 bean으로 등록 되어 지지 않는다.
    public Holoman holoman(HolomanProperties properties) {
        Holoman holoman = new Holoman();
        holoman.setName(properties.getName());
        holoman.setHowLong(properties.getHowLong());
        return holoman;
    }
}
