package com.koreaIT.java.BAM;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;

		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("명령어 >> ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (cmd.equals("exit")) {
				break;
			}

			// 게시글 리스트 확인
			if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
				}
				System.out.println("번호	|	제목	|	날짜	");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.printf("%d	|	%s	|	%s	\n", article.id, article.title, article.regDate);

				}
			}
			// 게시글 쓰기
			else if (cmd.equals("article write")) {
				int id = lastArticleId + 1;

				lastArticleId = id;
				String regDate = Util.getNowDateStr();
				System.out.println("날짜 : " + regDate);
				System.out.printf("제목 : ");
				String title = sc.nextLine();

				System.out.printf("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(id, regDate, title, body);

				articles.add(article);

				System.out.println(id + "번 글이 생성되었습니다");
			}
			// 특정 게시물 확인
			else if (cmd.startsWith("article detail ")) {
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);

				// 특정 게시물을 찾는 기능

				Article foundArticle = null;
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);

					if (article.id == id) {

						foundArticle = article;
						// System.out.printf("%d번 게시물은 존재합니다.\n", id);

						break;
					}
				}

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
				}

				// 특정 게시물 출력
				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("날짜 : %s\n", foundArticle.regDate);
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.body);

			}
			// 게시물 삭제
			else if (cmd.startsWith("article delete ")) {
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				// -1로 초기화한 이유 --> 비어 있는 list를 표현, index가 아닌 값으로 초기화하는 것이 바람직.
				// 0으로 초기화 할 경우 articles[0]은 삭제되지 않음.
				int foundIndex = -1;
				// 특정 게시물 찾는 기능

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);

					if (article.id == id) {

						foundIndex = i;

						break;
					}
				}

				// 존재하지 않을 경우
				if (foundIndex == -1) {
					System.out.printf("%d번 게시물은 존재하지 않습니다 .\n", id);
				}

				articles.remove(foundIndex);

				System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);

			}
			// 게시물 수정하기
			else if(cmd.startsWith("article modify ")) {
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				Article foundArticle = null;
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);

					if (article.id == id) {

						foundArticle = article;
						// System.out.printf("%d번 게시물은 존재합니다.\n", id);

						break;
					}
				}
				// 존재하지 않을 경우
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
				}
				
				
				
				System.out.println("수정할 제목 : ");
				String title =  sc.nextLine();
				System.out.println("수정할 내용 : ");
				String body =  sc.nextLine();
				foundArticle.title = title;
				foundArticle.body = body;
				System.out.printf("%d번 글이 수정되었습니다.\n");
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
	String regDate;
	String title;
	String body;

	Article(int id, String regDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;

	}
}
