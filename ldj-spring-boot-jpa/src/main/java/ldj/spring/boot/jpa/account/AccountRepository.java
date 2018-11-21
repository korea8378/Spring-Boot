package ldj.spring.boot.jpa.account;

import org.springframework.data.jpa.repository.JpaRepository;

//엔티티 타입, 식별자 타입(기본키)
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserName(String username);
}
