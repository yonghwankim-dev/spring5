package spring.chap04_02.before;

import java.time.LocalDateTime;

import spring.DuplicateMemberException;
import spring.Member;
import spring.MemberDao;
import spring.RegisterRequest;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req)
	{
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member!=null)
		{
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(
										req.getEmail(),
										req.getPassword(),
										req.getName(),
										LocalDateTime.now()
									);
		memberDao.insert(newMember);
		return newMember.getId();
	}
	
}
