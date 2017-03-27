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

	// ��ȡSqlSession
	public SqlSession getSqlSession() throws IOException {
		// ͨ�������ļ���ȡ���ݿ�������Ϣ
		Reader reader = Resources
				.getResourceAsReader("yk/resource/mybatis.xml");
		// ͨ��������Ϣ����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		// ͨ��SqlSessionFactory��һ�����ݿ�Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;

	}

	// ��ͨ��ѯ
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

	// ������ѯ
	@SuppressWarnings("finally")
	public List<TX> queryParam(TX tx) {
		try {
			// ����Ҫ�����Ĳ�����ֵ
			tx.setName(tx.getName());
			sqlSession = getSqlSession();
			// ����ֻ�ܼ�һ��ƥ�����
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
	
	// where��ǩ��ѯ
	@SuppressWarnings("finally")
	public List<TX> queryWhere(TX tx) {
		try {
			// ����Ҫ�����Ĳ�����ֵ
			tx.setName(tx.getName());
			sqlSession = getSqlSession();
			// ����ֻ�ܼ�һ��ƥ�����
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

	// ɾ��
	public void deleteOne(int id) throws IOException {
		sqlSession = getSqlSession();
		sqlSession.delete("TX.deleteOne", id);
		// mybatisĬ�������ύ��ʽΪ ���Զ��ύ
		sqlSession.commit();
	}

	// ɾ��
	public void deleteBatch(List<Integer> list) throws IOException {
		sqlSession = getSqlSession();
		sqlSession.delete("TX.deleteBatch", list);
		// mybatisĬ�������ύ��ʽΪ ���Զ��ύ
		sqlSession.commit();
	}

	// ����
	public void addOne(TX tx) throws IOException {
		sqlSession = getSqlSession();
		sqlSession.insert("TX.insertOne", tx);
		sqlSession.commit();
	}

	// ����
	public void updateOne(TX tx) throws IOException {
		sqlSession = getSqlSession();
		sqlSession.insert("TX.updateOne", tx);
		sqlSession.commit();
	}

}
