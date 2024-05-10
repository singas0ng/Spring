package kh.mcalss.test1.sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//이 클래스가 servlet 역할을 했으면 좋겠어 -> annotation 으로 controller라고 하고 추가하기
//위에 annotation 으로 인해 new 하면서 class 생성됨
public class TestController {
	@Autowired
	//이렇게 쓰면 TestService class 갖다 쓸 수 있음(new 대신임)
	private TestService service;
	
	//GetMapping, PostMapping도 있음
	//doGet과 doPost의 역할이 확연히 달라서 RequestMapping은 좋지 X
	//RequestMapping 쓰고 싶으면 옆에 (method = RequestMethod.GET/Post) 이렇게 써줘야함
	//@RequestMapping(method = RequestMethod.GET, path = "/test")
	//path 는 url 
	@GetMapping("/test")
	public String method1(String a, HttpServletRequest request, 
							HttpSession session,
							HttpServletResponse response) {
		//method이름은 그닥 중요하지 X
		//parameter 값 순서 상관없음 -> 자료형들 가지고 있어서 차료형에 맞춰서 넣어주기 때문에 순서 상관 X
		
		System.out.println(a);
		System.out.println(request.getParameter("a"));
		request.getSession().setAttribute("b", "세션값");
		session.setAttribute("c", "세션값2");
		
		request.setAttribute("serverTime", service.method1());
		return "home";
		//home.jsp 출력됨
	
	}
}
