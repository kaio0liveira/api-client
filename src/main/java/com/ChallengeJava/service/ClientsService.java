package com.ChallengeJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ChallengeJava.entity.Clients;
import com.ChallengeJava.exception.ClientNotFoundException;
import com.ChallengeJava.repository.ClientRepository;

@Service
public class ClientsService {
	
	@Autowired
	private ClientRepository clientsRepository;
	
	public ClientsService(ClientRepository clientsRepository2) {
		
		this.clientsRepository = clientsRepository2;
	}
	//validação de cliente, caso ID não existir
	public Clients findById(Long id) throws ClientNotFoundException {
		Optional<Clients> client = clientsRepository.findById(id);

		if(!client.isPresent()) {
			throw new ClientNotFoundException("ID " + id + " not found!");
		}
		return client.get();
	}
	public List<Clients> findAll() {
		return clientsRepository.findAll();
	}

	public void delete(Long id) throws ClientNotFoundException {
		//validando ID
		findById(id);
		clientsRepository.deleteById(id);
	}
	
	public Clients update(Long id, Clients client) throws ClientNotFoundException {
		//validando ID
		findById(id);

		client.setId(id);
		return clientsRepository.save(client);
	}
	
	public Clients save(Clients client) throws ClientNotFoundException {
		
		Optional<Clients> cpf = clientsRepository.findByCpf(client.getCpf());
		if(cpf.isPresent()) {
			
			throw new ClientNotFoundException("O CPF: "+ cpf.get().getCpf()+" já existe!");
		}
		
		if(client.getCpf().length() > 11) {
			throw new ClientNotFoundException("CPF superior a 11 caracteres: "+ client.getCpf().length());
		}
		
		return clientsRepository.save(client);
	}
	
	
}
