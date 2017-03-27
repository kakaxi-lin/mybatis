package yk.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import yk.po.TX;

public class BaseDao {

	SqlSession sqlSession = null;
	List<TX> txList = null;

	// 获取SqlSession
	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件获取数据库连接信息
		Reader reader = Resources
				.getResourceAsReader("yk/resource/mybatis.xml");
		// 通过配置信息构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		// 通过SqlSessionFactory打开一个数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;

	}

	// 普通查询
	@SuppressWarnings("finally")
	public List<TX> query() {
		try {
			sqlSession = getSqlSession();
			txList = sqlSession.selectList("TX.query");
			/*
			 * System.out.println(txList.size()); for(TX tx:txList){
			 * System.out.println(tx); }
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
			return txList;
		}
	}

	// 参数查询
	@SuppressWarnings("finally")
	public List<TX> queryParam(TX tx) {
		try {
			// 设置要检索的参数及值
			tx.setName(tx.getName());
			sqlSession = getSqlSession();
			// 后面只能加一个匹配参数
			txList = sqlSession.selectList("TX.queryParam", tx);
			/*
			 * System.out.println(txList.size()); for(TX txObj:txList){
			 * System.out.println(txObj); }
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
			return txList;
		}
	}
	
	// where标签查询
	@SuppressWarnings("finally")
	public List<TX> queryWhere(TX tx) {
		try {
			// 设置要检索的参数及值
			tx.setName(tx.getName());
			sqlSession = getSqlSession();
			// 后面只能加一个匹配参数
			txList = sqlSession.selectList("TX.queryWhere", tx);
			/*
			 * System.out.println(txList.size()); for(TX txObj:txList){
			 * System.out.println(txObj); }
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
			return txList;
		}
	}

	// 删除
	public void deleteOne(int id) throws IOException {
		sqlSession = getSqlSession();
		sqlSession.delete("TX.deleteOne", id);
		// mybatis默认事务提交方式为 不自动提交
		sqlSession.commit();
	}

	// 删除
	public void deleteBatch(List<Integer> list) throws IOException {
		sqlSession = getSqlSession();
		sqlSession.delete("TX.deleteBatch", list);
		// mybatis默认事务提交方式为 不自动提交
		sqlSession.commit();
	}

	// 增加
	public void addOne(TX tx) throws IOException {
		sqlSession = getSqlSession();
		sqlSession.insert("TX.insertOne", tx);
		sqlSession.commit();
	}

	// 更新
	public void updateOne(TX tx) throws IOException {
		sqlSession = getSqlSession();
		sqlSession.insert("TX.updateOne", tx);
		sqlSession.commit();
	}

}
