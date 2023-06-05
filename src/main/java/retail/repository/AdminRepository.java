package retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import retail.domain.Admin;
import retail.domain.Customer;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByUsername(@Param("username") String username);

    Admin findTopByFirstNameAndLastName(String firstName, String lastName);

    void deleteByUsername(String username);
}
