package blog.com.admin.api;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import blog.com.entity.News;
import blog.com.service.NewsService;

 

@RestController
@CrossOrigin
@RequestMapping("/admin/api")
public class AdminNewsApi {

	@Autowired
	private NewsService newsService;

	@GetMapping(value = "/news")
	public List<News> getNews() {		
		return newsService.findAll();
	}

	@GetMapping(value = "/news/{id}")
	public News getNewsOne(@PathVariable("id") Long id) {
		return newsService.findById(id);
	}

	@PostMapping(value = "/news")
	public News saveCategory(@RequestBody News news) {
		news.setSlug(news.getTitle());
		return newsService.save(news);
	}

	@DeleteMapping(value = "/news")
	public void deleteNews(@RequestBody long[] ids) {
		newsService.delete(ids);
	}

	@PutMapping(value = "/news/{id}")
	public News updateNews(@RequestBody News news, @PathVariable("id") Long id) {		
		news.setId(id);
		return newsService.save(news);
	}
	
	
	public static String converSlug(String title) {
		String temp = Normalizer.normalize(title, Normalizer.Form.NFD);
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    System.out.println(pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d") );
	    return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d");
		  
	}
	
}
