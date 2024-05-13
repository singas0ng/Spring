package kh.mclass.test1.sub.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kh.mclass.test1.sub.member.model.dto.MemberRes;
import kh.mclass.test1.sub.member.model.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/list")
	public String selectList(
			//request가 엄청 커서 필요한 부분만 달라고 하기
			Model model
			//jsp로 보낼때 는 model이라고 하는 interface 로 보냄(생성된 객체를 집어넣어줌) - 자료만 넣음
			//model에 실을 때 jsp 로 이동 - 애초에 setting을 model 과 view가 한 세트로 움직임 - 해당하는 view로 데이터 실어보냄
			
			) {
		
		List<MemberRes> list = memberService.selectList();
		
		model.addAttribute("memberList", list);
		
		return "member/list";
		//view 파일이 views까지가 prefix라서 views 밑에 member 폴더 안에 list.jsp가 있어서
		//  prefix 가 views 뒤에 / 있기 때문에 앞에 / 이거 안써도됨
	}
	
}
