package com.example.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.DTO.ArticleDto;

@Service
public class ArticleService {

	@Value("${article.api}")
	
	private String articlesApi;
	
	
public List<ArticleDto> getAllArticles() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List> response =  restTemplate.getForEntity(articlesApi, List.class);
		
		return response.getBody();
	}

	public ArticleDto getArticlesById(int id) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String apiUrl = articlesApi.concat("/").concat(String.valueOf(id));
		ArticleDto articleDTO = restTemplate.getForObject(apiUrl, ArticleDto.class);
		
		
		return articleDTO;
	}

	public ArticleDto addArticle(ArticleDto articleDTO) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		articleDTO.setCreatedAt(new Date());
		
		HttpEntity<ArticleDto> entity = new HttpEntity<ArticleDto>(articleDTO);
		ResponseEntity<ArticleDto> responseDTO = restTemplate.exchange(articlesApi, HttpMethod.POST, entity, ArticleDto.class);
		
		return responseDTO.getBody();
	}

	public ArticleDto deleteArticle(int id) {
		System.out.println("Delete method");
		RestTemplate restTemplate = new RestTemplate();
		
		String apiUrl = articlesApi.concat("/").concat(String.valueOf(id));
		
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ArticleDto> entity = new HttpEntity<ArticleDto>(headers);
		
		System.out.println("Here");
		ResponseEntity<ArticleDto> responseDTO = restTemplate.exchange(apiUrl, HttpMethod.DELETE, entity, ArticleDto.class);
		System.out.println("After response");
		return responseDTO.getBody();
	}
	
	
}
