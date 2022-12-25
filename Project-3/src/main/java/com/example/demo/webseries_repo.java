package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface webseries_repo extends JpaRepository<series,Integer>{
	
	 @Query(value = "SELECT * FROM series s where s.seriesid = ?1", nativeQuery = true)
	 List<series> findById(int id);
	    
	 @Query(value="SELECT * FROM series s where s.name=?1",nativeQuery=true)
	 List<series> findByName(String name);
	 
	 @Modifying
	 @Transactional 
	 @Query(value = "DELETE FROM series WHERE seriesid = ?1 ", nativeQuery = true)
	 void deleteAllByIdInBatch(int id);
	 
	 @Transactional
	 @Modifying
	 @Query(value = "Update series s set s.seriesid = ?1 ,s.name=?2, s.seasons =?3 , s.episode = ?4 , s.rating=?5  where s.seriesid = ?6 ", nativeQuery = true)
	 void update(int seriesid,String name,int seasons,int episode,int rating,int id);


		

}


