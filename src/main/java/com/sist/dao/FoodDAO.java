package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.*;
import com.sist.vo.*;
// 오라클만 연동
public class FoodDAO {
	   private static SqlSessionFactory ssf;
	   static
	   {
		   ssf=CreateSqlSessionFactory.getSsf();
	   }
	   
	   public static List<FoodVO> foodListData(Map map) {
		   List<FoodVO> list=null;
		   SqlSession session=null;
		   try {
			   session=ssf.openSession();
			   list=session.selectList("foodListData",map);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		return list;
	   }
	   
	   public static int foodTotalPage() {
		   int total=0;
		   SqlSession session=null;
		   try {
			   session=ssf.openSession();
			   total=session.selectOne("foodTotalPage");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		return total;
	   }
}
