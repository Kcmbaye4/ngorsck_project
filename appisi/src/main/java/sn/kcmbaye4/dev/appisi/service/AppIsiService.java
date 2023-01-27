package sn.kcmbaye4.dev.appisi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.kcmbaye4.dev.appisi.entities.Product;

import java.util.List;

public interface AppIsiService {
    Product addProduct(Product product);
    Page<Product> getAllProducts(Pageable pageable);

    Page<Product> findAllProdsByKeyword(String keyword, Pageable pageable);
    List<Product> saveAllProduct(List<Product> products);

    void deleteProduct(Long id);
    Product findProductById(Long id);

}
