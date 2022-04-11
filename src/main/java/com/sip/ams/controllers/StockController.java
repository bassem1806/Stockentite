package com.sip.ams.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sip.ams.entities.Article;
import com.sip.ams.entities.Stock;
import com.sip.ams.repositories.ArticleRepository;
import com.sip.ams.repositories.StockRepository;

@Controller
@RequestMapping("/stock/")
public class StockController {
	
	private final StockRepository stockRepository;
	private final ArticleRepository articleRepository;
	
	
	
	 @Autowired
	    public StockController(StockRepository stockRepository,ArticleRepository articleRepository) {
	     this.stockRepository  =stockRepository;
	     this.articleRepository =articleRepository;
	 }
		
	 
	 

	 @GetMapping("list")
	    public String listsstock(Model model) {
	    	//model.addAttribute("articles", null);
	    	List<Stock> la = (List<Stock>)stockRepository.findAll();
	    	if(la.size()==0)
	    	{
	    		la = null;
	    	}
	        model.addAttribute("stocks", la);
	        return "stock/listStocks";
	    }
	 
	 

	 @GetMapping("add")
	    public String showAddStockForm(Stock stock, Model model) {
	  	    	model.addAttribute("articles", articleRepository.findAll());
	          	model.addAttribute("stock", new Stock());
	        return "stock/addStock";
	    }
	 
	
		
		 
		

	@PostMapping("add/save")
		/* @ResponseStatus(value=HttpStatus.OK)
		    @ResponseBody*/
		 public String addStock(@Valid Stock stock, BindingResult result, 
				 @RequestParam(name = "articleId", required = true) Long a)
		      
		    		
		    		 {
		    	
			 Article article = articleRepository.findById(a).orElseThrow(()-> new IllegalArgumentException
					 ("Invalid article Id:" +a));
			 System.out.println("libille artile" +article.getLabel());
		    	stock.setArticle(article);
		    	
		    	
		    			   		    		   		    	
		   	 stockRepository.save(stock);
	 	 return "redirect:list";
		
		    	 }
	 
	 
	 @GetMapping("delete/{id}")
	    public String deleteStock(@PathVariable("id") long id, Model model) {
	        Stock stock = stockRepository.findById(id)
	            .orElseThrow(()-> new IllegalArgumentException("Invalid stock Id:" + id));
	        stockRepository.delete(stock);
	        model.addAttribute("stocks", stockRepository.findAll());
	        return "stock/listStocks";
	    }
	
	

	 
	 @GetMapping("edit/{id}")
	    public String showStockFormToUpdate(@PathVariable("id") long id, Model model) {
	        Stock stock = stockRepository.findById(id)
	            .orElseThrow(()->new IllegalArgumentException("Invalid provider Id:" + id));
	        
	        System.out.println(stock);
	        model.addAttribute("stock", stock);
	        
	        return "stock/updateStock";
	    } 
	 @PostMapping("update")
	    public String updateStock(@Valid Stock stock, BindingResult result) {
	    	 if (result.hasErrors()) {
	             return "stock/updateStock";
	         }
	    	stockRepository.save(stock);
	    	return"redirect:list";
	    	
	    }
	

}