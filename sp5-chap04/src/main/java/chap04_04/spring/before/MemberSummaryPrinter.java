package chap04_04.spring.before;

import chap04_04.spring.Member;
import chap04_04.spring.MemberPrinter;

public class MemberSummaryPrinter extends MemberPrinter{

	@Override
	public void print(Member member) {
		System.out.printf("회원정보 : 이메일=%s, 이름=%s\n",member.getEmail(), member.getName());
	}
	
}
