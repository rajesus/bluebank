package com.bluebank.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;

@ViewScoped
public class ContaController implements Serializable {
	private static final long serialVersionUID = 1;
	private Cliente cliente = new Cliente();
	private Conta conta = new Conta();
	
	private TipoOperacaoCC transferCC = new TipoOperacaoCC();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
    
	public int verificaConta( int numAgenciaDestino, int numContaDestino, float valor){
		 return 1;
	}
}
