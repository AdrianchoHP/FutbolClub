package com.FutbolClub.App.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.FutbolClub.App.Entity.Entrenadores;

public interface EntrenadorRepository extends MongoRepository<Entrenadores, String>{
	boolean existsByNombre(String nombre);
}