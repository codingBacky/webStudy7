package com.backy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 CREATE TABLE product (
    code number(5) primary key,
    name VARCHAR2(100),
    price Number(8),
    pictureurl VARCHAR2(50),
    description VARCHAR2(1000)
);
*/

@Getter
@Setter
@ToString
public class ProductVO {
	
	private int code;
	private String name;
	private int price;
	private String pictureurl;
	private String description;
}
