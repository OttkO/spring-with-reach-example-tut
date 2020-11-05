package nl.foreside.fullstackexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component 
public class DatabaseLoader implements CommandLineRunner { 

	private final ProductRepository repository;

	@Autowired 
	public DatabaseLoader(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {	
		this.repository.save(new Product("Nesquick", "Drink", "Delicious beverage."));
	}
}