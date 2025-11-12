package com.sist.vo;
import java.util.*;

import lombok.Data;
@Data
public class ReplyVO {
	private int no,type,rno,group_id,group_step,group_tab,root,depth;
	private String id,name,sex,msg,dbday;
	private Date regdate;
}
