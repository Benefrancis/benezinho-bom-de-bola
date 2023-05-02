package br.com.fiap.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * @author Benefrancis do Nascimento
 * <p>
 * Classe que representa o Atleta
 */
@Entity
@Table(name = "TB_ATLETA",
        uniqueConstraints = {@UniqueConstraint(
                name = "UK_CPF_ATLETA",
                columnNames = "NR_CPF"
        )})
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ATLETA")
    @SequenceGenerator(name = "SQ_ATLETA", sequenceName = "SQ_ATLETA")
    @Column(name = "ID_ATLETA")
    private long id;

    @Column(name = "NM_ATLETA")
    private String nome;

    @Column(name = "DT_NASCIMENTO")
    private LocalDate nascimento;

    @Column(name = "NR_CPF")
    private String CPF;

    private float altura;
    private float peso;

    public Atleta() {
    }

    public Atleta(long id, String nome, LocalDate nascimento, String CPF, float altura, float peso) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.CPF = CPF;
        this.altura = altura;
        this.peso = peso;
    }

    public long getId() {
        return id;
    }

    public Atleta setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Atleta setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public Atleta setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        return this;
    }

    public String getCPF() {
        return CPF;
    }

    public Atleta setCPF(String CPF) {
        this.CPF = CPF;
        return this;
    }

    public float getAltura() {
        return altura;
    }

    public Atleta setAltura(float altura) {
        this.altura = altura;
        return this;
    }

    public float getPeso() {
        return peso;
    }

    public Atleta setPeso(float peso) {
        this.peso = peso;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atleta{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", nascimento=").append(nascimento);
        sb.append(", CPF='").append(CPF).append('\'');
        sb.append(", altura=").append(altura);
        sb.append(", peso=").append(peso);
        sb.append('}');
        return sb.toString();
    }
}
