package com.sist.vo;

import java.util.*;

import lombok.Data;

@Data
public class NoticeVO {
	private int no,hit;
	private String state,name,subject,content,filename,filesize,dbday;
	private Date regdate;
}
