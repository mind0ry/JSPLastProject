package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.*;
import com.sist.vo.*;
public class MyPageDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	public static List<ReserveVO> reserveMyPageListData(String id) {
		List<ReserveVO> list=null;
		try {
			SqlSession session=ssf.openSession();
			list=session.selectList("reserveMyPageListData",id);
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
	}
	
	/*<select id="reserveOkData" resultMap="rMap" parameterType="int">
	  SELECT no,rday,ri.time,inwon,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,
	  		poster,name,address,phone,parking,score,type
	  FROM reserve_info ri, menupan_food mf
	  WHERE ri.fno=mf.fno
	  AND no=#{no}
	</select>
	*/
	
	public static ReserveVO reserveOkData(int no) {
		ReserveVO vo=null;
		try {
			SqlSession session=ssf.openSession();
			vo=session.selectOne("reserveOkData",no);
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}
	

}
