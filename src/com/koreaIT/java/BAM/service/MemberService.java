package com.koreaIT.java.BAM.service;

import com.koreaIT.java.BAM.container.Container;
import com.koreaIT.java.BAM.dto.Member;

public class MemberService {

	public int setArticleId() {

		return Container.memberDao.setArticleId();
	}

	public void add(Member member) {
		Container.memberDao.add(member);

	}

	public Member getMemberByLoginId(String loginId) {

		return Container.memberDao.getMemberByLoginId(loginId);
	}

	public boolean loginIdChk(String loginId) {

		return Container.memberDao.loginIdChk(loginId);
	}

	public String getWriterName(int memberId) {
		
		return Container.memberDao.getWriterName(memberId);
	}

}
