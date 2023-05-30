package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe GerenciamentoVotacao.
 */
public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> listaPessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> listaPessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;

  /**
   * Método que cadastrarPessoaCandidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);

    for (PessoaCandidata candidato : listaPessoasCandidatas) {
      if (Objects.equals(candidato.getNumero(), numero)) {
        System.out.println("Número da Pessoa Candidata já está sendo utilizado!\n");
        return;
      } else if (Objects.equals(candidato.getNome(), nome)) {
        System.out.println("Nome da Pessoa Candidata já está sendo utilizado!\n");
        return;
      }
    }

    if (nome.length() < 3) {
      System.out.println("Nome precisa ter no mínimo 3 caracteres!\n"
          + "Tente novamente !\n");
    } else if (numero == 0) {
      System.out.println("Número precisa ser maior que Zero!\n" + "Tente novamente !\n");
    } else {
      listaPessoasCandidatas.add(pessoaCandidata);
      System.out.println("Candidato Cadastrado com Sucesso!\n");
    }
  }

  /**
   * Método que cadastrarPessoaEleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);


    for (PessoaEleitora eleitor : listaPessoasEleitoras) {
      if (Objects.equals(eleitor.getCpf(), cpf)) {
        System.out.println("Número de CPF da pessoa eleitora já está sendo utilizado!\n");
        return;
      } else if (Objects.equals(eleitor.getNome(), nome)) {
        System.out.println("Nome da pessoa eleitora já está sendo utilizado!\n");
        return;
      }
    }

    if (nome.length() < 3) {
      System.out.println("Nome precisa ter no mínimo 3 caracteres!\n"
          + "Tente novamente !\n");
    } else if (cpf.length() != 11) {
      System.out.println("O CPF precisa ter 11 caracteres!\n" + "Tente novamente !\n");
    } else {
      listaPessoasEleitoras.add(pessoaEleitora);
      System.out.println("Eleitor Cadastrado com Sucesso!\n");
    }
  }

  /**
   * Método para votar.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    String cpfFormatado = cpfPessoaEleitora.replaceAll(
        "(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

    for (PessoaCandidata candidato : listaPessoasCandidatas) {
      if (cpfComputado.contains(cpfPessoaEleitora)) {
        System.out.println("eleitora CPF " + cpfFormatado + " já votou!\n");
        return;
      } else if (!Objects.equals(candidato.getNumero(), numeroPessoaCandidata)) {
        System.out.println("Número de candidato inválido!\n");
        return;
      } else if (Objects.equals(candidato.getNumero(), numeroPessoaCandidata)) {
        candidato.receberVoto();
        cpfComputado.add(cpfPessoaEleitora);
        totalVotos += 1;
        System.out.println("Voto computado com Sucesso!\n");
        return;
      }
    }
  }

  //  public void mostrarResultado() {
  //    if (this.totalVotos == 0) {
  //      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
  //    } else {
  //      for (int index = 0; index < this.listaPessoasCandidatas.size(); index += 1) {
  //        PessoaCandidata candidato = this.listaPessoasCandidatas.get(index);
  //        double porcentagem = mostraPorcentagem(index);
  //        System.out.println("Nome: "
  //        + candidato.getNome() + " - "
  //        + candidato.getVotos()
  //        + " votos "
  //            + "( " + porcentagem + "% )");
  //      }
  //      System.out.println("Total de votos: " + this.totalVotos);
  //    }
  //  }

  /**
   * Método para mostrarResultado.
   */
  public void mostrarResultado() {
    if (this.totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      for (PessoaCandidata candidato : this.listaPessoasCandidatas) {
        double porcentagem = mostraPorcentagem(this.listaPessoasCandidatas.indexOf(candidato));
        System.out.println("Nome: "
            + candidato.getNome()
            + " - "
            + candidato.getVotos()
            + " votos "
            + "( " + porcentagem + "% )");
      }
      System.out.println("Total de votos: " + this.totalVotos);
    }
  }

  /**
   * Método para mostraPorcentagem.
   */
  public double mostraPorcentagem(int index) {
    return ((double) listaPessoasCandidatas.get(index).getVotos() / getTotalVotos() * 100);
  }

  public ArrayList<PessoaCandidata> getListaPessoasCandidatas() {
    return listaPessoasCandidatas;
  }

  public void setListaPessoasCandidatas(ArrayList<PessoaCandidata> listaPessoasCandidatas) {
    this.listaPessoasCandidatas = listaPessoasCandidatas;
  }

  public ArrayList<PessoaEleitora> getListaPessoasEleitoras() {
    return listaPessoasEleitoras;
  }

  public void setListaPessoasEleitoras(ArrayList<PessoaEleitora> listaPessoasEleitoras) {
    this.listaPessoasEleitoras = listaPessoasEleitoras;
  }

  public ArrayList<String> getCpfComputado() {
    return cpfComputado;
  }

  public void setCpfComputado(ArrayList<String> cpfComputado) {
    this.cpfComputado = cpfComputado;
  }

  public int getTotalVotos() {
    return totalVotos;
  }

  public void setTotalVotos(int totalVotos) {
    this.totalVotos = totalVotos;
  }
}
