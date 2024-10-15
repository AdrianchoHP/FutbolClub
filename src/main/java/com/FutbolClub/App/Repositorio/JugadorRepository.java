package com.FutbolClub.App.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.FutbolClub.App.Entity.Jugadores;


public interface JugadorRepository extends MongoRepository<Jugadores, String>{
	boolean existsByNombre(String nombre);
	 Jugadores findByNombre(String nombre);
	void deleteByNombre(String nombre);
	
}
	
