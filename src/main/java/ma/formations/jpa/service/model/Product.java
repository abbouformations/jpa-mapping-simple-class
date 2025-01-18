package ma.formations.jpa.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Product  {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long identifiant;
	@Column(nullable = false, length = 30)
	private String designation;

	public Product(String designation) {
		super();
		this.designation = designation;
	}
}
