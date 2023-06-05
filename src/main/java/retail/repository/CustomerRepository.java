package retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import retail.domain.Customer;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    @Query("select  distinct  c from Customer c join c.user.roles r where c.firstName = :firstName and c.lastName = :lastName and c = 'CUSTOMER'")
    Customer findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName")String lastName);


    Customer findByUsername(@Param("username") String username);

    Customer findTopByFirstNameAndLastName(String firstName, String lastName);

    void deleteByUsername(String username);

//    void deleteByIdAndRoles(long id, String role);
//    List<Customer> findAllByRoles(String role);
//
//    Customer findByIdAndRoles(long id, String role);
//
//    Customer findByUsernameAndRoles(String username, String role);
//
//    List<Customer> findByRoles(String role);
}
