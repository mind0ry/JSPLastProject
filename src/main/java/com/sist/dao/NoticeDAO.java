package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.*;
import com.sist.vo.*;
public class NoticeDAO {
	private static SqlSessionFactory ssf;
	  static
	  {
		  ssf=CreateSqlSessionFactory.getSsf();
	  }
	  
	  public static void noticeInsert(NoticeVO vo) {
		  try {
			  SqlSession session=ssf.openSession(true);
			  session.insert("noticeInsert",vo);
			  session.close();
		  } catch (Exception ex){
			  ex.printStackTrace();
		  }
	  }
	  
	  public static List<NoticeVO> noticeListData(int start) {
		 List<NoticeVO> list=null;
		 try {
			 SqlSession session=ssf.openSession();
			 list=session.selectList("noticeListData",start);
			 session.close();
		 } catch (Exception ex) {
			 ex.printStackTrace();
		 }
		 return list;
	  }
	  
	  public static int noticeTotalPage() {
		  int total=0;
		  try {
			  SqlSession session=ssf.openSession();
			  total=session.selectOne("noticeTotalPage");
		  } catch (Exception ex) {
			  ex.printStackTrace();
		  }
		  return total;
	  }
	  
	  public static NoticeVO noticeDetailData(int no) {
		  NoticeVO vo=null;
		  try {
			  SqlSession session=ssf.openSession();
			  session.update("noticeHitIncrement",no);
			  session.commit();
			  vo=session.selectOne("noticeDetailData",no);
			  session.close();
     	  } catch (Exception ex) {
     		  ex.printStackTrace();
		  }
		  
		  return vo;
	  }
	  
}
 