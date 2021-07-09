package config.chap04_02.after;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberPrinter;
import spring.chap04_02.after.ChangePasswordService;
import spring.chap04_02.after.MemberInfoPrinter;
import spring.chap04_02.after.MemberListPrinter;
import spring.chap04_02.after.MemberRegisterService;
import spring.chap04_02.after.VersionPrinter;

@Configuration
public class AppCtx{
	
	@Bean
	public MemberDao memberDao() 
	{
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc()
	{
		return new MemberRegisterService();
	}
	
	@Bean
	public ChangePasswordService changePwdSvc()
	{
		ChangePasswordService pwdSvc = new ChangePasswordService();
		// 의존을 주입하지 않아도 스프링이 @Autowired가 붙인 필드에
		// 해당 타입의 빈 객체를 찾아서 주입한다.
		return pwdSvc;
	}
	
	@Bean
	public MemberPrinter memberPrinter()
	{
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter()
	{
		return new MemberListPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter()
	{
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter()
	{
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}