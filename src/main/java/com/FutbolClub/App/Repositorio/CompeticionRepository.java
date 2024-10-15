package com.FutbolClub.App.Repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.FutbolClub.App.Entity.Competiciones;

public interface CompeticionRepository extends MongoRepository<Competiciones, String>{
	 boolean existsByNombre(String nombre);
	 List<Competiciones> findByNombre(String nombre);
	

}