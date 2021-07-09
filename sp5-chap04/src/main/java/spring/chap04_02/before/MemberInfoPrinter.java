package spring.chap04_02.before;

import org.springframework.beans.factory.annotation.Autowired;

import spring.Member;
import spring.MemberDao;
import spring.MemberPrinter;

public class MemberInfoPrinter {
	private MemberDao memDao;
	private MemberPrinter printer;
	
	public void printMemberInfo(String email)
	{
		Member member = memDao.selectByEmail(email);
		if(member==null)
		{
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
	
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	
}
