package org.nbk.product.repository;

import java.util.List;

import org.nbk.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Product> findAll() {
		return mongoTemplate.findAll(Product.class);
	}

	public Product save(Product product) {
		System.out.println(product);
		return mongoTemplate.save(product);
	}

	public Product getById(String productId) {
		return mongoTemplate.findOne(prepareQuery("productId", productId), Product.class);
	}

	public List<Product> getByCategoryId(String categoryId) {
		return mongoTemplate.find(prepareQuery("category.categoryId", categoryId), Product.class);
	}

	private Query prepareQuery(String key, String value) {
		CriteriaDefinition cd = Criteria.where(key).is(value);
		Query query = Query.query(cd);
		return query;
	}
}