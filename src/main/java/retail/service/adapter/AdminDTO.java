package retail.service.adapter;

import lombok.Data;

@Data
public class AdminDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String email;


    public AdminDTO() {
        super();
        // TODO Auto-generated constructor stub
    }
    public AdminDTO(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
