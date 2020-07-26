package blog.com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.com.entity.News;
import blog.com.service.NewsService;
 

@RestController
@CrossOrigin
@RequestMapping("/api")
public class NewsApi {

	@Autowired
	private NewsService newsService;
	
	@GetMapping(value = "/news")
	public List<News> getNews() {
		return newsService.findAll();
	}
	
	@GetMapping(value = "/news/top")
	public List<News> getTopNews() {
		return newsService.findTopRecent();
	}
	
	@GetMapping(value = "/news/{id}")
	public News getNewsOne(@PathVariable("id") Long id) {
		return newsService.findById(id);
	}
}
