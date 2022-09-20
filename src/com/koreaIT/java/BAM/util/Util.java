package com.koreaIT.java.BAM.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	//현재 시간 및 날짜 리턴
	public static String getNowDateStr(){        
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   	 
		Date now = new Date(); 
		       
		String nowTime1 = sdf1.format(now);        
		         
       return nowTime1;
       }
	
}
