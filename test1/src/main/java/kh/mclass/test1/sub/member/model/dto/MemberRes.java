package kh.mclass.test1.sub.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@ToString //generate toString 해줌
//@AllArgsConstructor //argument 가지고 있는 생성자도 만들어줌(생성자 안에 매개인자 있는거)
//@NoArgsConstructor //매개인자 없는 생산자
//@Getter
//@Setter
@Data //위에꺼 한꺼번에 걸어줌
public class MemberRes {
	private String memId;
	private String memPwd;
	private String memEmail;
	
}
