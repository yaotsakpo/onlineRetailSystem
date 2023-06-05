package retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import retail.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(@Param("username") String username);
}
