package com.sist.vo;
import java.util.*;

import lombok.Data;
@Data
public class JjimVO {
	private int jno,type,rno;
	private String id, dbday;
	private Date regdate;
	private FoodVO fvo=new FoodVO();
	private GoodsVO gvo=new GoodsVO();
	private RecipeVO rvo=new RecipeVO();
}
