package com.ChallengeJava.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import com.ChallengeJava.entity.Clients;
import com.ChallengeJava.exception.ClientNotFoundException;
import com.ChallengeJava.repository.ClientRepository;

class ClientsServiceTest {
	
	@InjectMocks
	private ClientsService service;

	@Mock
	private ClientRepository clientsRepository;

	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
	}

	// Testando Exceção
	@Test
	void buscarClientePorIdCasoNaoExistir() throws ClientNotFoundException {

		Clients cliente = new Clients(1L, null, null, null);

		Mockito.when(clientsRepository.findById(any())).thenReturn(Optional.of(cliente));

		try {
			service.findById(2L);
		} catch (Exception e) {
			Assertions.assertEquals("ID 2 not found!", e.getMessage());
			
		}

	}

	// Buscando cliente caso ID existir
	@Test
	void buscarClientePorId() throws ClientNotFoundException {

		Clients cliente = new Clients(1L, "kaio", "12345678", null);
		
		Mockito.when(clientsRepository.findById(1L)).thenReturn(Optional.of(cliente));

		Clients resultado = service.findById(1L);

		Assertions.assertEquals("kaio", resultado.getName());

	}

}
