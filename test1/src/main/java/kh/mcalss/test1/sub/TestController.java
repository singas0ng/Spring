package kh.mcalss.test1.sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
//이 클래스가 servlet 역할을 했으면 좋겠어 -> annotation 으로 controller라고 하고 추가하기
//위에 annotation 으로 인해 new 하면서 class 생성됨
public class TestController {
	@Autowired
	//이렇게 쓰면 TestService class 갖다 쓸 수 있음
	// -> new로 객체를 선언하지 않고 에노테이션으로 호출
	private TestService testService;

	@GetMapping("/test")
	public String method1(@RequestParam(defaultValue = "a1", required = false) String a, HttpServletRequest request, 
							HttpSession session,
							HttpServletResponse response) {

		System.out.println(a);
		System.out.println(request.getParameter("a"));
		request.getSession().setAttribute("b", "세션값");
		session.setAttribute("c", "세션값2");
		
		request.setAttribute("serverTime", testService.method1());
		return "home";
		//home.jsp 출력됨
	
	}
}
