package kh.mclass.test1.sub;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
//누군가가 이 TestService 쓰고 싶은 사람이 있다면 new 쓰지 않고 사용 가능
//이걸 쓰면 controller에서 new로 객채를 선언하지 않아도 호출가능
// html의 div 같은 존재
@Service("testService")
//servlet-context.xml 에서 <annotation-driven /> 설정 안하면 얘 동작 안함
public class TestService {
	public String method1() {
		return "서비스리턴값";
	}

}
