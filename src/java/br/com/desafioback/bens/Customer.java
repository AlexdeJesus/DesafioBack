package br.com.desafioback.bens;
/** *
 * @author Alex Souza
 */
public class Customer {
    private int id;
    private String cpf;
    private String nome;
    private boolean ativo;
    private double valorTotal;
/*
    public Customer(int id, String cpf, String nome, boolean ativo, double valor) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.ativo = ativo;
        this.valor = valor;
    }
        */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
