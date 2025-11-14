package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.*;
import com.sist.vo.*;
import com.sist.commons.*;
public class ReserveDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
/*
 * 	<select id="reserveFoodListData" resultType="FoodVO" parameterType="string">
	  SELECT fno,name,poster,type,rownum
	  FROM (SELECT fno,name,poster,type
	  FROM menupan_food ORDER BY fno)
	  WHERE rownum&lt;=100
	  AND type LIKE '%'||#{type}||'%'
	</select>
 */
	public static List<FoodVO> reserveFoodListData(String type) {
		List<FoodVO> list=null;
		try {
			SqlSession session=ssf.openSession();
			list=session.selectList("reserveFoodListData",type);
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	/*
	 * <select id="reserveDateTimes" resultType="string" parameterType="int">
		  SELECT times FROM reserve_date
		  WHERE dno=#{dno} 
		</select>
		<select id="reserveTime" resultType="string" parameterType="int">
		  SELECT time FROM reserve_time
		  WHERE tno=#{tno}
		</select>
	 */
	public static String reserveDateTimes(int dno) {
		String times="";
		try {
			SqlSession session=ssf.openSession();
			times=session.selectOne("reserveDateTimes",dno);
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return times;
	}
	
	public static String reserveTime(int tno) {
		String times="";
		try {
			SqlSession session=ssf.openSession();
			times=session.selectOne("reserveTime",tno);
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return times;
	}
	
	public static void reserveInsert(ReserveVO vo) {
		try {
			SqlSession session=ssf.openSession(true);
			session.insert("reserveInsert",vo);
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	<delete id="reserveCancel" parameterType="int">
	  DELETE FROM reserve_info
	  WHERE no=#{no}
	</delete>
	 */
	public static void reserveCancel(int no) {
		try {
			SqlSession session=ssf.openSession(true);
			session.delete("reserveCancel",no);
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
