package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class series {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private int seriesid;
    private String name ;
    private int seasons ,episode ,rating;
    
    series() {}

    series(int seriesid,String name,int seasons,int episode,int rating)

    {

        this.setSeriesid(seriesid);

        this.setName(name);
        
        this.setSeasons(seasons);
        
        this.setEpisode(episode);
        
        this.setRating(rating);

    }

	public int getSeriesid() {
		return seriesid;
	}

	public void setSeriesid(int seriesid) {
		this.seriesid = seriesid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeasons() {
		return seasons;
	}

	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}

	public int getEpisode() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
