package com.FutbolClub.App.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.FutbolClub.App.Entity.Asociaciones;

public interface AsociacionRepository extends MongoRepository<Asociaciones, String>{
	boolean existsByNombre(String nombre);
}
