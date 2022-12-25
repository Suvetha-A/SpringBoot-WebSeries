package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class Add {
	
	

	@Autowired webseries_repo ob;

	@PostMapping("/addSeries")
		public String saveSeries(@RequestBody series series1)
		{
		series a= new series();
		
		int id= series1.getSeriesid();
		String name = series1.getName();
		int seasons= series1.getSeasons();
		int episode = series1.getEpisode();
		int rating= series1.getRating();
		
		a.setSeriesid(id);
		a.setName(name);
		a.setSeasons(seasons);
		a.setEpisode(episode);
		a.setRating(rating);
		
		series first = new series(id,name,seasons,episode,rating);
		ob.save(first);
		
	return "Added successfully";

		}
	
	@GetMapping("/series")
    public List<series> getAllseries()
    {

        return ob.findAll();

    }
    
    @GetMapping("series/{id}")
    public List<series> getSeriesById(@PathVariable("id") int id){
    

    	return ob.findById(id);

        
    }
    
    @GetMapping("/series/name/{name}")
	public List<series> getSeriesByName(@PathVariable("name") String name)   
	{  
		return ob.findByName(name);  
	}
	
		
	@PutMapping("/update/{id}")
	public String update(@RequestBody series s,@PathVariable("id") int id)
    {
		
	 	 
		int id1= s.getSeriesid();
		String name = s.getName();
		int seasons= s.getSeasons();
		int episode = s.getEpisode();
		int rating= s.getRating();
		ob.update(id1,name,seasons,episode,rating,id);
			 
		return "successfully updated";
}

	
	@DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable("id") int id)
    {
	 
		ob.deleteAllByIdInBatch(id);
		
		return "deleted successfully";
}

}
