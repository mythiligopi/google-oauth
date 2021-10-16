package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.ArticleDto;
import com.example.service.ArticleService;

@RestController
@RequestMapping("/articles")

public class ArticleController {
	
	@Autowired
	
	private ArticleService articleService;
	
	
	@GetMapping("")
	public ResponseEntity<List<ArticleDto>> getAllArticles() {
		return new ResponseEntity<List<ArticleDto>>(articleService.getAllArticles(), HttpStatus.OK) ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ArticleDto> getArticleById(@PathVariable int id) {
		return new ResponseEntity<ArticleDto>( articleService.getArticlesById(id),HttpStatus.OK);   
	} 
	
	
	@PostMapping("")
	public ResponseEntity<ArticleDto> addArticle(@RequestBody ArticleDto articleDTO) {
		System.out.println("POST");
		return new ResponseEntity<ArticleDto>(articleService.addArticle(articleDTO),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ArticleDto> deleteArticle(@PathVariable int id) {
		System.out.println("Delete");
		return new ResponseEntity<ArticleDto>(articleService.deleteArticle(id),HttpStatus.OK);
	}

}

	                   
	
	
	


