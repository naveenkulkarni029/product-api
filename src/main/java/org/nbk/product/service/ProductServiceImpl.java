package org.nbk.product.service;

import java.util.List;
import java.util.UUID;

import org.nbk.product.domain.Category;
import org.nbk.product.domain.Product;
import org.nbk.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Value("${product.category}")
	private String categoryURI;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product save(Product product) {
		System.out.println(product);
		product.setProductId(UUID.randomUUID().toString());
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getById(String productId) {
		return productRepository.getById(productId);
	}

	@Override
	public List<Product> getByCategoryId(String categoryId) throws HttpClientErrorException, HttpServerErrorException {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(categoryURI + categoryId, HttpMethod.GET, null, Category.class);
		return productRepository.getByCategoryId(categoryId);
	}
}