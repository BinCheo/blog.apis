package com.thanhbinhtruong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhbinhtruong.entity.News;
import com.thanhbinhtruong.repository.NewsRepository;
 

@Service
public class NewsService {

	 @Autowired
	 private NewsRepository newsRepository;
	 
	 public List<News> findAll() {
			List<News> rs = newsRepository.findAll();
			return rs;
		}
	 public List<News> findTopRecent() {
			List<News> rs = newsRepository.findTopRecent();
			return rs;
		}
		public News save(News news) {
			newsRepository.save(news);
			return news;
		}
		
		public void delete(long[] ids) {
			for(long item: ids) {
				newsRepository.deleteById(item);
			}	
		}
		
		public News findById(Long id) {
			return newsRepository.findById(id).get();
		}
		

}
