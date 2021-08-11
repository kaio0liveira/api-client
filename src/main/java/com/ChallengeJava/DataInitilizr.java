package com.ChallengeJava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ChallengeJava.entity.Clients;
import com.ChallengeJava.entity.Endereco;
import com.ChallengeJava.repository.ClientRepository;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	ClientRepository repos;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Endereco endereco = new Endereco("Quadra 20", "Rua", 10);
		Clients cliente1 = new Clients(1L,"Teste", "12324353", endereco);
		
		
		
	
		
		
	List<Clients> cliente = repos.findByName("Kaio");
	
	cliente.stream().forEach(cliente2 -> System.out.println(cliente2.getCpf()));
		
}
}
