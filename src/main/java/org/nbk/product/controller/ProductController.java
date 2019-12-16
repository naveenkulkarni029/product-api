package org.nbk.product.controller;

import java.util.List;

import org.nbk.product.domain.Product;
import org.nbk.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productSerivce;

	@ApiOperation(value = "Add a Product")
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		System.out.println(product);
		Product savedProduct = productSerivce.save(product);
		return ResponseEntity.created(null).body(savedProduct);
	}

	@ApiOperation(value = "View the Product", response = Product.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved product"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable String productId) {
		Product product = productSerivce.getById(productId);
		return ResponseEntity.ok(product);
	}

	@ApiOperation(value = "View a list of available Products", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> products = productSerivce.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping(value = "/all/category/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getByCategoryId(@PathVariable String categoryId) {
		List<Product> products = productSerivce.getByCategoryId(categoryId);
		return ResponseEntity.ok(products);
	}
}
