package com.sist.vo;
import java.util.*;

import lombok.Data;

@Data
public class ReviewVO {
   private int no,cno,type;
   private String name,msg,dbday,id;
   private Date regdate;
}
