package org.nbk.product.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nbk.product.domain.Product;
import org.nbk.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductsApiRestControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@Test
	public void getProductDetailsTest() throws Exception {

		when(productService.getById("1")).thenReturn(product());
		MockHttpServletResponse response = this.mockMvc.perform(get("/1")).andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		ObjectMapper mapper = new ObjectMapper();
		Product responseProduct = mapper.readValue(response.getContentAsString(), Product.class);

		assertThat(responseProduct).isEqualTo(product());

	}

	private Product product() {
		Product product = new Product();
		product.setProductName("Naveen");
		return product;
	}

}
