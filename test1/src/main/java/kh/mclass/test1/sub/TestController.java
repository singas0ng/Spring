package kh.mclass.test1.sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kh.mclass.test1.sub.model.dto.TestDto;

@Controller
//이 클래스가 servlet 역할을 했으면 좋겠어 -> annotation 으로 controller라고 하고 추가하기
//위에 annotation 으로 인해 new 하면서 class 생성됨
public class TestController {

	//annotation은 바로 아래 1개의 명령어에만 영향을 끼침
	@Autowired
	//이렇게 쓰면 TestService class 갖다 쓸 수 있음
	// -> new로 객체를 선언하지 않고 에노테이션으로 호출
	private TestService testService;

	
	//GetMapping, PostMapping도 있음
	//doGet과 doPost의 역할이 확연히 달라서 RequestMapping은 좋지 X
	//RequestMapping 쓰고 싶으면 옆에 (method = RequestMethod.GET/Post) 이렇게 써줘야함
	//@RequestMapping(method = RequestMethod.GET, path = "/test")
	//path 는 url 
	@GetMapping("/test")
	public String method1(@RequestParam(defaultValue = "aaa", required = false, name = "a") String a, HttpServletRequest request, 
			//@RequestParam 쓰면 반드시 이거 값 들고왔었어야함. 안그러면 에러 뜸
			//ex. url에 test=a?aa 이런식으로 썼었어야함
			//아무것도 안들고 오면 default값으로 이걸 주겠어 + false써서 굳이 안들고 와도되~ 라는 것을 설정
			//name을 지정해주면 값을 아무것도 들고오지 않았을 때 name 값을 String 뒤에 변수명 안에 여기에 넣어주겠다(뵨수명은 상관X)
							HttpSession session,
							HttpServletResponse response) {
		//method이름은 그닥 중요하지 X
		//parameter 값 순서 상관없음 -> 자료형들 가지고 있어서 차료형에 맞춰서 넣어주기 때문에 순서 상관 X
		
		//parameter가 4개라서 AdviceLog.java에 있는 args에 4개가 찍힘

		System.out.println(a);
		System.out.println(request.getParameter("a"));
		request.getSession().setAttribute("b", "세션값");
		session.setAttribute("c", "세션값2");

		request.setAttribute("serverTime", testService.method1());
		return "home";
		//home.jsp 출력됨
	
	}
	
	@GetMapping("/test/one")
	public String method2(
			@RequestParam(defaultValue = "aaa", required = false, name = "a") String b,
			HttpServletRequest request,  
			HttpSession ss,
			HttpServletResponse res
			) {
		System.out.println(b);
		System.out.println(request.getParameter("a"));
		request.getSession().setAttribute("b", "세션값");
		ss.setAttribute("c", "세션2");
		
		request.setAttribute("serverTime", testService.method1());
		return "home";
	}
	
}
