package kh.mclass.test1.sub.model.dto;

import org.springframework.stereotype.Component;

//@Component("testDto")
//servlet-context.xml에서 bean으로 썼으면 이거 쓰면 안됨 - 둘 중 하나 써야함
//annotation 으로 dto생성하면 compile 돌 때 만들어지기 때문에 기본 생성자 있어야함
public class TestDto {
	private String a1;
	private String a2;
	private TestFileDto testFileDto;
	
	//root-context.xml 에 파일에 init-method 넣어주면 이거 쓸 필요 X
	//private void init() {
		//초기에 처음 한번만 동작시키고 싶은 얘들 여기에 넣음
		//중간중간 필요한 얘들 있으면 중간중간 초기화해서 쓸 수 있음 - 초기화 메소드
		//초기화 메소드 만들어서 지정 가능
		
		//System.out.println("init");
		//compile하는 중간에 실행
	//}
	
	@Override
	public String toString() {
		return "TestDto [a1=" + a1 + ", a2=" + a2 + ", testFileDto=" + testFileDto + "]";
	}
	
	public TestDto() {
		super();
		
	}
	//

	public TestDto(String a1, String a2, TestFileDto testFileDto) {
		super();
		//init();
		this.a1 = a1;
		this.a2 = a2;
		this.testFileDto = testFileDto;
	}

//	public TestDto(String a2) {
//		super();
//		this.a2 = a2;
//	}
	
	public TestDto(String a1, String a2) {
		super();
		this.a1 = a1;
		this.a2 = a2;
	}
	


	public String getA1() {
		return a1;
	}


	public void setA1(String a1) {
		this.a1 = a1;
	}

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public TestFileDto getTestFileDto() {
		return testFileDto;
	}

	public void setTestFileDto(TestFileDto testFileDto) {
		this.testFileDto = testFileDto;
	}
	
	
	
}
