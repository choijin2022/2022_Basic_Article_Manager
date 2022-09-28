package com.koreaIT.java.BAM.service;

import java.util.ArrayList;
import java.util.List;

import com.koreaIT.java.BAM.container.Container;
import com.koreaIT.java.BAM.dto.Article;

public class ArticleService {

	public List<Article> getForArticles(String searchKeyword) {
		
		return Container.articleDao.getForPrintArticles(searchKeyword);
	}

}
