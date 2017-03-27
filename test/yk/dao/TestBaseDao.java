package yk.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import yk.po.TX;

public class TestBaseDao {
	BaseDao bd =new BaseDao();
	
	@Test
	public void testQuery(){
		List<TX> txList = bd.query();
		System.out.println(txList.size());
		for(TX tx:txList){
			System.out.println(tx);
		}
	}
	
	@Test
	public void testQueryParam(){
		TX tx=new TX();
		tx.setName("¿­¸ç");
		List<TX> txList = bd.queryParam(tx);
		System.out.println(txList.size());
		for(TX txObj:txList){
			System.out.println(txObj);
		}
		
	}
	
	@Test
	public void testQueryWhere(){
		TX tx=new TX();
		tx.setName("¿¨¿¨");
		tx.setId(13);
		List<TX> txList = bd.queryWhere(tx);
		System.out.println(txList.size());
		for(TX txObj:txList){
			System.out.println(txObj);
		}
		
	}
	
	@Test
	public void testDeleteOne() throws IOException{
		bd.deleteOne(26);
		
	}
	
	@Test
	public void testDeleteBatch() throws IOException{
		List<Integer> list=new ArrayList<Integer>();
		list.add(30);
		list.add(31);
		bd.deleteBatch(list);
		
	}
	
	@Test
	public void testAddOne() throws IOException{
		TX tx=new TX();
		tx.setName("¿¨¿¨¿­");
		bd.addOne(tx);
		
	}
	
	@Test
	public void testUpdateOne() throws IOException{
		TX tx=new TX();
		tx.setName("¿¨¿¨");
		tx.setId(13);
		bd.updateOne(tx);
		
	}

}
