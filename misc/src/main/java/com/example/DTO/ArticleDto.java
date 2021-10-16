package com.example.DTO;

import java.util.Date;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ArticleDto {
	
	
	private int id;
	private String name;
	private Date CreatedAt ;
	private String Avatar;
	

}
