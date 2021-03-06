package ldj.spring.boot.neo4j;

import ldj.spring.boot.neo4j.account.Account;
import ldj.spring.boot.neo4j.account.AccountRepository;
import ldj.spring.boot.neo4j.account.Role;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {

//    @Autowired
//    SessionFactory sessionFactory;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setEmail("korea8378@naver.com");
        account.setUsername("leedongjun");

        Role role = new Role();
        role.setUsername("admin");
        role.setEmail("lee@naver.com");

        account.getRoles().add(role);

        accountRepository.save(account);

        //        Session session = sessionFactory.openSession();
//        session.save(account);
//        sessionFactory.close();

        System.out.println("finished");

    }
}
