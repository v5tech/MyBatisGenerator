package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.model.Product;
import com.mybatis.persistence.ProductMapper;

@Service
public class ProductService {
	@Autowired
	private ProductMapper productMapper;

	List<Product> getProductListByCategory(String categoryId){
		return productMapper.getProductListByCategory(categoryId);
	}

	Product getProduct(String productId){
		return productMapper.getProduct(productId);
	}

	List<Product> searchProductList(String keywords){
		return productMapper.searchProductList("%"+keywords+"%");
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	void save(Product product){
		productMapper.save(product);
	}
}
