package kh.mclass.test1.sub.member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.mclass.test1.sub.member.model.dto.MemberRes;

@Repository("memberDao")
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberRes> selectList(){
		return sqlSession.selectList("Member.List"); 
	}
	
	public int insert(){
		sqlSession.update("Member.List");
		return 0; 
	}
	
	public int update(){
		sqlSession.update("Member.List");
		return 0; 
	}
}
