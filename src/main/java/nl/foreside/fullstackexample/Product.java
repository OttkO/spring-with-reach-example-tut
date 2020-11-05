package nl.foreside.fullstackexample;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	private @Id @GeneratedValue Long id; 
	private String name;
	private String category;
	private String description;
	
	private Product() {
		
	}
	
	
	public Product(String productName, String category, String description) {
		this.name = productName;
		this.category = category;
		this.description = description;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(id, product.id) &&
			Objects.equals(name, product.name) &&
			Objects.equals(category, product.category) &&
			Objects.equals(description, product.description);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, category, description);
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description + "]";
	}
		
}
