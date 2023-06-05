package retail.domain;


import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class CreditCard {
    @Id
    @GeneratedValue
    private long Id;
    private int Number;
    private Date ExpirationDate;
    private int SecurityCode;

}
