package tacos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;



@Data
@Entity
@RequiredArgsConstructor
@Table(name = "ingredient")
public class Ingredient {
	@Id
	private final String id;
	
	@Column
	private final String name;
	
	@Column
	private final Type type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Taco taco;

	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}