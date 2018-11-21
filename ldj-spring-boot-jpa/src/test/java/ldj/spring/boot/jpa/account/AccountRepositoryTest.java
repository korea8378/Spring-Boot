package ldj.spring.boot.jpa.account;

import javafx.beans.binding.Bindings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest//슬라이스 테스트 JPA 레파지토리에 관련된 빈들을 주입 받아서 테스트 할 수 있다. 인메모리 데이터베이스가 필요하다.
//@SpringBootTest 현재 프로젝트에 설정 된 bean들이 모두 등록 된다.
public class AccountRepositoryTest {

    @Autowired
    DataSource dataSource; //데이터베이스 연결 정보

    @Autowired
    JdbcTemplate jdbcTemplate; //JDBC 템플릿

    @Autowired
    AccountRepository accountRepository;

//    @Test
//    public void di() {
//        빈메소드를 만들어서 빈들이 제대로 주입이 되는지 test 할 수 있다.
//    }

    @Test
    public void di() throws SQLException {
        Account account = new Account();
        account.setUsername("dongjun");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);

        assertThat(newAccount).isNotNull();

        Account existingAccount = accountRepository.findByUserName("dongjun");
        assertThat(existingAccount).isNotNull();

        Account nonExistingAccount = accountRepository.findByUserName("none");
        assertThat(nonExistingAccount).isNotNull();
    }


}