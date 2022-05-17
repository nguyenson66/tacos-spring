package tacos;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "taco")
public class Taco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id auto increment
	private Long id; 
	
	@Column
	@CreationTimestamp
	private Date createdAt;
	
	@Column
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY)
	@Size(min=1, message="You must choose at least 1 ingredient")
	private List<Ingredient> ingredients;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;
}
