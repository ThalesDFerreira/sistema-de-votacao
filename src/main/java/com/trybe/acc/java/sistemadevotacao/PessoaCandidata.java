package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe PessoaCandidata que estende de Pessoa.
 */
public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  /**
   * Método Construtor da Classe PessoaCandidata.
   */
  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
    this.votos = 0;
  }

  public int getVotos() {
    return votos;
  }

  public int getNumero() {
    return numero;
  }

  public int receberVoto() {
    return this.votos += 1;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }



}
