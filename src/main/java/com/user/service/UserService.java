package com.user.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.model.Product;

@FeignClient(url="http://localhost:8080/", name="product-service")
public interface UserService {
	
	@RequestMapping(method=RequestMethod.GET, value="/product-service/listproducts")
	public List<Product> getData();
	
	@RequestMapping(method=RequestMethod.GET, value="/product-service/listproductsbyid/{productId}")
	public Product getProductsById(@PathVariable("productId") String productId);

}
