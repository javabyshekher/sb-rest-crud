package in.ashokit.controller;

import in.ashokit.model.Product;
import in.ashokit.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    private ProductService service;

    public ProductRestController(ProductService service) {
        this.service = service;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Product> storeProduct(@RequestBody Product product) {
        Product productFromService = service.saveProduct(product);
        return new ResponseEntity<>(productFromService, HttpStatus.CREATED);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product productFromService = service.fetchProduct(id);
        if (productFromService != null)
            return new ResponseEntity<>(productFromService, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product productAfterUpdate = service.updateProduct(product);
        return new ResponseEntity<>(productAfterUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted", HttpStatus.OK);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>>  getAllProducts() {
        List<Product> products = service.fetchAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
