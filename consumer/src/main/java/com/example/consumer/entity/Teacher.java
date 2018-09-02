package com.example.consumer.entity;

public class Teacher {
	private Integer id;
	private String name;
	private String course;
	private String img;
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getCourse(){
		return course;
	}
	
	public void setCourse(String course){
		this.course = course;
	}
	
	public String getImg(){
		return img;
	}
	
	public void setImg(String img){
		this.img = img;
	}
	
}
