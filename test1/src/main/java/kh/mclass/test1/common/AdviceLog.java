package kh.mclass.test1.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect //aspect 기능 있는데 어떤 추가 기능이 있는지는 모름
@Component
public class AdviceLog {
	
	private Logger logger = LoggerFactory.getLogger(AdviceLog.class);
	//해당 클래스에 logger를 작성할 수 있도록 함
	// => sysout 대신해서 씀
	
	//private 까지 걸고싶으면 public 대신 * 적기
	//return 타입은 모든 것
	//패키지명
	//클래스는 dao로 끝나는 얘들한테 aspect 다 걸어줄거야 - dao 로 끝나지 않으면 message log 안나옴(대소문자 구별함!!!)
	//메소드 - 모든 것
	// PARAMETER - 뭐든지 상관 X
	//pointcut에 이름 정해야함 - 클래스라 이름을 달리 정할 방법 없어서 메소드 이름을 정하고 메소드 이름으로 작성
	@Pointcut("execution(public * kh..*Dao..*(..))")
	public void daoPointcut() {
		//execution으로 걸려있는 이름이 이 daoPointcut
	}

	@Pointcut("execution(public * kh..*Service..*(..))")
	public void servicePointcut() {
		
	}
	
	@Pointcut("execution(public * kh..*Controller..*(..))")
	public void controllerPointcut() {
		
	}
	
	//advise 걸어주기
	@Around("daoPointcut()")
	public Object aroundDaoLog(ProceedingJoinPoint pjp) throws Throwable {
		//ProceedingJoinPoint 자료형의 pjp 변수명을 parameter로 들고 들어옴
		
		Object returnObj = null;
		
		//System.out.println("pjp.getThis()는 클래스명은" + pjp.getThis() + ", 이거의 메소드명 - " + pjp.getSignature().getName());
		logger.debug("pjp.getThis()는 클래스명은" + pjp.getThis() + ", 이거의 메소드명 - " + pjp.getSignature().getName());
		//trace의 위의 등급
		
		
		// pjp.getArgs() - 위의 메소드의 parameter 값들이 들어있음(없으면 아무것도 안보일것) - parameter 값을 이제 얘가 찍어줌
		Object[] args = pjp.getArgs();
		//object의 배열모양으로 넘어옴

		for(int i = 0; i < args.length; i++) {
			//System.out.println("▷▷▷-args["+ i + "] " + args[i] + "");
			logger.trace("▷▷▷-args["+ i + "] " + args[i] + "");
		}
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		//pjp.proceed();가 타겟메소드명인데 이거 호출
		
		returnObj = pjp.proceed();
		//proceed() 가 throws Throwable이라고 써있음 - pjp.proceed();가 타겟메소드명
		
		stopwatch.stop();
		
		logger.debug("▷▷▷[Dao ▷ "+stopwatch.getTotalTimeMillis()+"ms]"+returnObj);
		//해당 메소드가 db갔다오는데 얼마나 걸렸고 controller안에서 얼마나 많은 시간을 보내는지 checking 해서 뿌려줌
		
		return returnObj;
		
	}
	
	
	@Around("controllerPointcut()")
	public Object aroundControllerLog(ProceedingJoinPoint pjp) throws Throwable {
		//ProceedingJoinPoint 자료형의 pjp 변수명을 parameter로 들고 들어옴
		
		Object returnObj = null;
		
		System.out.println("pjp.getThis()는 클래스명은" + pjp.getThis() + ", 이거의 메소드명 - " + pjp.getSignature().getName());
		
		// pjp.getArgs() - 위의 메소드의 parameter 값들이 들어있음(없으면 아무것도 안보일것) - parameter 값을 이제 얘가 찍어줌
		Object[] args = pjp.getArgs();
		//object의 배열모양으로 넘어옴

		for(int i = 0; i < args.length; i++) {
			System.out.println("▷-args["+ i + "] " + args[i] + "");
		}
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		//pjp.proceed();가 타겟메소드명인데 이거 호출
		
		returnObj = pjp.proceed();
		//proceed() 가 throws Throwable이라고 써있음 - pjp.proceed();가 타겟메소드명
		
		stopwatch.stop();
		
		logger.debug("▷[Ctrl ▷ "+stopwatch.getTotalTimeMillis()+"ms]"+returnObj);
		//해당 메소드가 db갔다오는데 얼마나 걸렸고 controller안에서 얼마나 많은 시간을 보내는지 checking 해서 뿌려줌
		
		return returnObj;
		
	}
	
	//warning - error 정도만 고객사에게..
	
	//@Before("controllerPointcut()")
	public void beforeControllerLog(JoinPoint jp) {
		//먼저 해야하는 상황이 존재 -> proxy (proxy를 거쳤다 가는데 그 역할을 AOP가 함)
		logger.debug("▷[" + jp.getThis() + ", 이거의 메소드명 - " + jp.getSignature().getName() + "]");
		//parameter 값을 들어있음
		Object[] args = jp.getArgs();
		//object의 배열모양으로 넘어옴

		for(int i = 0; i < args.length; i++) {
			System.out.println("▷-args["+ i + "] " + args[i] + "");
		}
	}
	
}
