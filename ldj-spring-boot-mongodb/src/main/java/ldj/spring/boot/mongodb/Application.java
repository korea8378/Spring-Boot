package ldj.spring.boot.mongodb;

import ldj.spring.boot.mongodb.account.Account;
import ldj.spring.boot.mongodb.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class Application {

    @Autowired
//    MongoTemplate mongoTemplate;
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Account account = new Account();
            account.setEmail("lee@lee");
            account.setUsername("lee");
            accountRepository.insert(account);

            System.out.println("finished");
        };
    }
}
