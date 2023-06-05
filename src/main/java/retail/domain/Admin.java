package retail.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name="Admin")
public class Admin {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String passwordHash;
    private String passwordSalt;
    @Column(nullable = false)
    private String email;
    @OneToMany
    @JoinColumn(name = "user_id")
    private Collection<OrderHistory> OrderHistories;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    public Admin(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Admin(){super();};
}
