package tacos;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.CreditCardNumber;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "taco_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id auto increment
	private Long id; 
	
	@NotBlank(message="Name is required")
	@Column
	private String deliveryName;
	
	@NotBlank(message="street is required")
	@Column
	private String deliveryStreet;
	
	@Column
	@NotBlank(message="city is required")
	private String deliveryCity;
	
	@Column
	@NotBlank(message="state is required")
	private String deliveryState;
	
	@Column
	@NotBlank(message="zip is required")
	private String deliveryZip;
	
	@Column
	@CreditCardNumber(message="Not a valid credit card number")
	private String ccNumber;
	
	@Column
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",message="Must be formatted MM/YY")
	private String ccExpiration;
	
	@Column
	@Digits(integer=3, fraction=0, message="Invalid CVV")
	private String ccCVV;
	
	@CreationTimestamp
	private Date placedAt;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Taco> tacos;
}
