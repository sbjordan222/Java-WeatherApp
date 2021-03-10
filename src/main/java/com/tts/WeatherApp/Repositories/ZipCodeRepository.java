package com.tts.WeatherApp.Repositories;

import com.tts.WeatherApp.Models.ZipCodes;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCodes, Long>{
	ZipCodes findByZipCode(String zip);
	
	@Query(value = "SELECT ZIP_CODE,FROM ZIP_CODES ORDER BY CREATED_AT DESC LIMIT 10",
			nativeQuery = true)
	List<String> findMostRecent();
}