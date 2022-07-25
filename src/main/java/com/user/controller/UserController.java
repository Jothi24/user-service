package com.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.user.model.Product;
import com.user.service.UserService;

@RestController
@RequestMapping("/user-service")
public class UserController {
	@Autowired
	private UserService loadBalancer;
	
	
	@GetMapping("/listProducts")
	public List<Product> getListOfProducts() throws RestClientException, IOException {

		List<Product> prod = new ArrayList<>();
		try {
			prod = loadBalancer.getData();
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return prod;
	}
	

	@GetMapping("/listproducts/{productId}")
	public Product getListOfProductsByProductId(@PathVariable(value = "productId") String productId) throws RestClientException, IOException {

		Product prod = new Product();
		
		try {
			prod = loadBalancer.getProductsById(productId);
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return prod;
	}
}
