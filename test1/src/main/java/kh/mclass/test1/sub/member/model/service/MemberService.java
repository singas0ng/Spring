package kh.mclass.test1.sub.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.mclass.test1.sub.member.model.dao.MemberDao;
import kh.mclass.test1.sub.member.model.dto.MemberRes;

@Service("memberService")
@Transactional
//둘다 해당 클래스에 적용 - 한개가 아니라 어려가개 그 다음 명령어에 적용 가능
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
	//이 안에서 오류가 발생하면 자연스럽게 rollback 해줌
	//얘를 인식하려면 pom.xml 에 jar가 있거나 servlet-context.xml에서 scanning 해줘야함
	//@Transactional
	public List<MemberRes> selectList(){
		memberDao.insert();
		memberDao.update(); //update 는 0이 return 된다고해서 오류 아님
		
		return memberDao.selectList(); 
	}
	
	public void insertAbc() {
		//pointcut 으로 설정한 부분을 여기에 집어넣어줌
	}
}
