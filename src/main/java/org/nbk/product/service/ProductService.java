package org.nbk.product.service;

import java.util.List;

import org.nbk.product.domain.Product;

public interface ProductService {

	Product save(Product product);

	List<Product> getAllProducts();

	Product getById(String productId);

	List<Product> getByCategoryId(String categoryId);

}
