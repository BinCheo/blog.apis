package com.thanhbinhtruong.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thanhbinhtruong.entity.Category;
import com.thanhbinhtruong.service.CategoryService;

 

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CategoryApi {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/category")
	public List<Category> getCategory() {
		return categoryService.findAll();		 
	}
}