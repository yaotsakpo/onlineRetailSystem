package retail.domain;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class User extends org.springframework.security.core.userdetails.User {
    @Id
    @GeneratedValue
    private long Id;
    private String username;
    private String Email;
    private String password;
    private String PasswordSalt;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();


    public User() {
        super("default","default", Stream.of("CUSTOMER")
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList()));
    }

    public User(String username, String email, String password, String passwordSalt, Set<String> roles) {
        super(username,password,roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList()));
        this.username = username;
        Email = email;
        this.password = password;
        PasswordSalt = passwordSalt;
        this.roles = roles;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return PasswordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        PasswordSalt = passwordSalt;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
