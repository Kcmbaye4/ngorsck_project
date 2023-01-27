package sn.kcmbaye4.dev.appisi.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.kcmbaye4.dev.appisi.dao.ProductDao;
import sn.kcmbaye4.dev.appisi.entities.Product;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AppIsiServiceImpl implements AppIsiService {

    private ProductDao productDao;

    @Override
    public Product addProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productDao.findAll(pageable);
    }

    @Override
    public Page<Product> findAllProdsByKeyword(String keyword, Pageable pageable) {
        return productDao.findByNameContains(keyword, pageable);
    }



    @Override
    public List<Product> saveAllProduct(List<Product> products) {
        return productDao.saveAll(products);
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.deleteById(id);
    }

    @Override
    public Product findProductById(Long id) {
        return productDao.findById(id).orElse(null);
    }
}
