package com.ChallengeJava.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ChallengeJava.entity.Clients;


@Repository
public interface ClientRepository extends JpaRepository<Clients, Long>{

     //List<Clients> findByName(String nome);
	
	
	List<Clients> findByName(String nome);
	
	Optional<Clients> findByCpf(String cpf);

	
}
