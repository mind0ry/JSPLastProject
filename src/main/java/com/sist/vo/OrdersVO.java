package com.sist.vo;

import java.util.*;

import lombok.Data;
@Data
public class OrdersVO {
	private int no,gno,account,price;
	private String id,name,post,addr1,addr2,msg,dbday;
	private Date regdate;
	
	private GoodsVO gvo=new GoodsVO(); 
}
