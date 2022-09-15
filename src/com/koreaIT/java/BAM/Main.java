package com.koreaIT.java.BAM;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		
		
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		
		List<Article> articles = new ArrayList<>();
		
		
		while(true) {
			System.out.printf("명령어 >> ");
			String cmd = sc.nextLine().trim();
			

			if(cmd.length()==0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			
			if(cmd.equals("exit")) {
				break;
			}
			
			
			// 게시글 리스트 확인
			if(cmd.equals("article list")) {
				if(articles.size()==0) {
					System.out.println("게시글이 없습니다.");
					continue;
				}
				System.out.printf("번호	|	제목");
				for(int i = articles.size()-1; i >=0 ; i--) {
					Article article = articles.get(i);
					
					System.out.printf("%d, %s\n", article.id, article.title);
							
					

				}
			}
			// 게시글 쓰기
			else if(cmd.equals("article write")) {
				int id = lastArticleId +1;
				lastArticleId = id;
				System.out.printf("제목 : ");
				String title  = sc.nextLine();
				
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				String nowTime = sdf1.format(now);
				System.out.println(sdf1.format(now));
				
				Article article = new Article(id, title, body, nowTime);
				
				articles.add(article);
				
				System.out.println(id+"번 글이 생성되었습니다");
			}
			// 특정 게시물 확인
			else if(cmd.startsWith("article detail ")) {
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				boolean found = false;
				for(int i = 0; i <articles.size(); i++) {
					Article article = articles.get(i);
					
					if(article.id == id) {
						found = true;
						System.out.printf("%d번 게시물은 존재\n", id);
					}
				}
				
				if(found == false) {
				System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
				}
			}
			else
				System.out.println("존재하지 않는 명령어입니다.");
		}
		
		
	
		
		System.out.println("== 프로그램 종료 ==");
		
		sc.close();
	}
}

class Article {
	int id;
	String title;
	String body;
	String nowTime;
	
	Article(int id, String title, String body, String nowTime ){
		this.id = id;
		this.title = title;
		this.body = body;
		this.nowTime = nowTime;
		
	}
}
