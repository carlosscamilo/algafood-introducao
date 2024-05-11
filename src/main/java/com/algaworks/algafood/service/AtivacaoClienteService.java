package com.algaworks.algafood.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.modelo.Cliente;

@Service
public class AtivacaoClienteService {

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@PostConstruct
	public void init() {
		System.out.println("INIT");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
	}

}
