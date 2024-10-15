package com.FutbolClub.App.Repositorio;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.FutbolClub.App.Entity.Clubes;

public interface ClubRepository extends MongoRepository<Clubes, String>{
	boolean existsByNombre(String nombre);
}