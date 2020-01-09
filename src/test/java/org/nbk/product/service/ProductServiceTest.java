package org.nbk.product.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.nbk.product.domain.Product;
import org.nbk.product.repository.ProductRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ProductServiceTest {
	
	private ProductService productService = Mockito.mock(ProductService.class);

	private ProductRepository productRepository = Mockito.mock(ProductRepository.class);

	public ProductServiceTest() {
		this.productService = new ProductServiceImpl(this.productRepository);
	}
	
	@Test
	public void getProductService() throws Exception {
		doReturn(product()).when(productRepository).getById("1");
		Product myProduct = productService.getById("1");
		assertThat(myProduct).isNotNull();
	}
	
	private Product product() {
		Product product = new Product();
		product.setProductName("Naveen");
		return product;
	}
	

}
