package com.sist.vo;


import java.util.*;

import lombok.Data;

@Data
public class ReserveVO {
	private int no,fno,ok;
	private String id,rday,time,dbday,inwon;
	private Date regdate;
	private FoodVO fvo=new FoodVO(); 
}
