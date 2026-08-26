package in.ashokit.service;

import in.ashokit.model.Product;
import in.ashokit.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Product fetchProduct(String id) {
        return repository.findById(id).orElse(null);
    }

    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }

    public List<Product> fetchAllProducts() {
        return repository.findAll();
    }
}
