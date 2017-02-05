package com.bluebank.controller;

public class Conta {
	private int numeroAgenciaOrigem;
	private int numeroAgenciaDestino;
	private int numeroContaOrigem;
	private int numeroContaDestino;
	private float valor;
	
    public Conta(){
    	
    }
	public int getNumeroAgenciaOrigem() {
		return numeroAgenciaOrigem;
	}
	public void setNumeroAgenciaOrigem(int numeroAgenciaOrigem) {
		this.numeroAgenciaOrigem = numeroAgenciaOrigem;
	}
	public int getNumeroAgenciaDestino() {
		return numeroAgenciaDestino;
	}
	public void setNumeroAgenciaDestino(int numeroAgenciaDestino) {
		this.numeroAgenciaDestino = numeroAgenciaDestino;
	}
	public int getNumeroContaOrigem() {
		return numeroContaOrigem;  
	}
	public void setNumeroContaOrigem(int numeroContaOrigem) {
		this.numeroContaOrigem = numeroContaOrigem;
	}
	public int getNumeroContaDestino() {
		return numeroContaDestino;
	}
	public void setNumeroContaDestino(int numeroContaDestino) {
		this.numeroContaDestino = numeroContaDestino;
	}
	public float getValor() {
		return valor; 
	}
	public void setValor(float valor) {
		this.valor = valor;
	}



}
