package ma.formations.jpa.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 9012467086918082200L;
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
