package kh.mclass.test1.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	//Interceptor: 툭볋한 url을 가로채서 동작할 수 있는 행동
	// => 가로채서 어떤 행동을 하고 원래 하려던 일의 위치로 보냄 - 보낸 후에 후 처리도 가능(posthandler로)
	//preHandle(): before 행동, postHandle(): after행동

	//url 진입 전에 한번, url 동작 다 끝나고 response를 하는 그 와중에 postHandler() 함
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//preHandle(): 실제 controller(handler)가 실행되기 전에 실행(url 진입 전에 실행)
		//=> boolean 타입의 값을 return 함
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("sslogin");
		//loginfilter는 후처리 필요 X
		
		if(obj == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			//false라고 하면 원래 가려던 곳으로 안가고 다음 행동을 하지 못하도록 자르고 내가 설정해준 url로 보냄
			// => sendRedirect랑 같이 써야함
			return false;
		} else {
			return true;
			//return true 면 원래 행동하려던 곳으로 보냄 => 원래 url 실핸
		}
		
	}
}
