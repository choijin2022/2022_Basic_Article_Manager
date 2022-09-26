package com.koreaIT.java.BAM.controller;

import com.koreaIT.java.BAM.dto.Member;

public abstract class Controller {
	public static Member loginedMember;

	public abstract void doAction(String cmd, String methodName);

	public abstract void makeTestData();

	// 로그인/로그아웃 확인 메서드
	public boolean isLogined() {
		return loginedMember != null;
	}

}
