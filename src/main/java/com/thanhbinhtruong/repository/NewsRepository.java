package com.thanhbinhtruong.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thanhbinhtruong.entity.News;

 

public interface NewsRepository extends JpaRepository<News, Long>{
	
	 @Query(value = "SELECT * FROM news.news  order by created_date desc limit 3;" , nativeQuery = true)
	 List<News> findTopRecent();
}
