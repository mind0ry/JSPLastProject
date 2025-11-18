package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.*;
import com.sist.vo.GoodsVO;
import com.sist.vo.OrdersVO;

public class GoodsDAO {

   private static SqlSessionFactory ssf;
   static {
      
      ssf = CreateSqlSessionFactory.getSsf();
            
   }
   
   /*
       <select id="goodsListData" resultType="GoodsVO" parameterType="hashmap">
         SELECT no,goods_name, goods_sub,goods_price, goods_discount, goods_poster,
            hit, num
         FROM (SELECT no,goods_name, goods_sub,goods_price, goods_discount, goods_poster,
               hit, rownum as num
            FROM (SELECT no,goods_name, goods_sub,goods_price, goods_discount, goods_poster,
            hit
               FROM ${goods} ORDER BY no ASC))
         WHERE num BETWEEN #{start} AND #{end}
      </select>
      <select id="goodsTotalPage" resultType="int" parameterType="hashmap">
         SELECT CEIL(COUNT(*)/12.0)
         FROM ${goods}
      </select>
    */
   public static List<GoodsVO> goodsListData(Map map){
      
      SqlSession session = ssf.openSession();
      List<GoodsVO> list = session.selectList("goodsListData",map);
      
      session.close();
      return list;
   }
   
   public static int goodsTotalPage(Map map) {
      SqlSession session = ssf.openSession();
      int total = session.selectOne("goodsTotalPage",map);
      
      session.close();
      
      return total;
   }
   
   /*
       <update id="goodsHitIncrement" parameterType="hashmap">
         UPDATE ${goods} SET
         hit = hi+1
         WHERE no=#{no}
      </update>
      <select id="goodsDetailData" resultType="GoodsVO" parameterType="int">
         SELECT * FROM ${goods}
         WHERE no = #{no}
      </select>
    */
   public static GoodsVO goodsDetailData(Map map) {
      SqlSession session = ssf.openSession();
      session.update("goodsHitIncrement",map);
      
      session.commit();
      GoodsVO vo = session.selectOne("goodsDetailData",map);
      session.close();
      
      return vo;
   }
   
   public static GoodsVO goodsCookieData(Map map) {

      
      SqlSession session = ssf.openSession();

      GoodsVO vo = session.selectOne("goodsDetailData",map);
      session.close();
      
      return vo;
   }
   
   public static void orderInsert(OrdersVO vo) {
	   try {
		   SqlSession session = ssf.openSession(true);

		   session.insert("orderInsert",vo);
		   session.close();
	   } catch (Exception ex) {
		   ex.printStackTrace();
	   }
   }
   
/*
 *<select id="orderListData" parameterType="string" resultMap="orderMap">
    SELECT no,gno,goods_poster,goods_name,goods_price,
    		account, TO_CHAR(regdate,'YYYY-MM-DD') as dbday
    FROM mvcOrders mo,goods_all ga
    WHERE mo.gno=ga.no
    AND id=#{id}
  </select>
 */
   public static List<OrdersVO> orderListData(String id) {
	   List<OrdersVO> list=null;
	   
	   try {
		   SqlSession session=ssf.openSession();
		   list=session.selectList("orderListData",id);
		   session.close();
	   } catch (Exception ex) {
		   ex.printStackTrace();
	   }
	   
	   return list;
   }
   
   /*
    * <select id="orderdetailData" parameterType="int" resultMap="orderMap">
    SELECT mo.no,gno,goods_poster,goods_name,goods_price,
    		account, TO_CHAR(regdate,'YYYY-MM-DD') as dbday,name,addr1,addr2,post,msg
    FROM mvcOrders mo,goods_all ga
    WHERE mo.gno=ga.no
    AND mo.no=#{no}
  </select>
    */
   public static OrdersVO orderDetailData(int no) {
	   OrdersVO vo=null;
	   
	   try {
		   SqlSession session=ssf.openSession();
		   vo=session.selectOne("orderDetailData",no);
		   session.close();
	   } catch (Exception ex) {
		   ex.printStackTrace();
	   }
	   return vo;
   }
   
}
