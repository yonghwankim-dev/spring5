package spring.chap04_02.after;

import org.springframework.beans.factory.annotation.Autowired;

import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;

public class ChangePasswordService {
	
	@Autowired	// 변경점
	private MemberDao memberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd)
	{
		Member member = memberDao.selectByEmail(email);
		if(member==null)
		{
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}
	
	public void setMemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
}
