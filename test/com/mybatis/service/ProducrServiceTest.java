package com.mybatis.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.model.Product;


public class ProducrServiceTest {
	
	@Test
	public void save(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		ProductService productService = applicationContext.getBean("productService", ProductService.class);
		Product product=new Product();
		product.setName("SONY");
		product.setPrice(79.0f);
		product.setDescription("SONY");
		product.setCategoryid("1");
		productService.save(product);
	}
	
	
	@Test
	public void getProduct(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		ProductService productService = applicationContext.getBean("productService", ProductService.class);
		Product product=productService.getProduct("1");
		System.out.println(product.getName()+"\t"+product.getDescription());
	}
	
	@Test
	public void getProductListByCategory(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		ProductService productService = applicationContext.getBean("productService", ProductService.class);
		List<Product> lists=productService.getProductListByCategory("2");
		for (Product product : lists) {
			System.out.println(product.getName()+"\t"+product.getDescription()+"\t"+product.getCategoryid());
		}
	}
	
	@Test
	public void searchProductList(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		ProductService productService = applicationContext.getBean("productService", ProductService.class);
		List<Product> lists=productService.searchProductList("ipad2");
		for (Product product : lists) {
			System.out.println(product.getName()+"\t"+product.getDescription()+"\t"+product.getCategoryid());
		}
	}
	
}
