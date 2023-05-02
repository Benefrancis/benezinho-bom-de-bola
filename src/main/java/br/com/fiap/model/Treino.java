package br.com.fiap.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * @author Benefrancis do Nascimento
 * <p>
 * Classe para representar o plano de treino específico para o atleta
 */
@Entity
@Table(name = "TB_TREINO")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TREINO")
    @SequenceGenerator(name = "SQ_TREINO", sequenceName = "SQ_TREINO")
    @Column(name = "ID_TREINO")
    private long id;

    @Column(name = "NM_TREINO")
    private String nome;

    @Column(name = "DESC_TREINO")
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_PREPARADOR",
            referencedColumnName = "ID_PREPARADOR",
            foreignKey = @ForeignKey(name = "FK_TREINO_PREPARADOR")
    )
    private Preparador preparador;

    @Column(name = "DT_INICIO")
    private LocalDateTime inicio;

    @Column(name = "DT_FIM")
    private LocalDateTime fim;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_FUNDAMENTO",
            referencedColumnName = "ID_FUNDAMENTO",
            foreignKey = @ForeignKey(name = "FK_TREINO_FUNDAMENTO")
    )
    private Fundamento fundamento;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_ATLETA",
            referencedColumnName = "ID_ATLETA",
            foreignKey = @ForeignKey(name = "FK_TREINO_ATLETA")
    )
    private Atleta atleta;


    public Treino() {
    }

    public Treino(long id, String nome, String descricao, Preparador preparador, LocalDateTime inicio, LocalDateTime fim, Fundamento fundamento, Atleta atleta) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preparador = preparador;
        this.inicio = inicio;
        this.fim = fim;
        this.fundamento = fundamento;
        this.atleta = atleta;
    }


    public long getId() {
        return id;
    }

    public Treino setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Treino setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Treino setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Preparador getPreparador() {
        return preparador;
    }

    public Treino setPreparador(Preparador preparador) {
        this.preparador = preparador;
        return this;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public Treino setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
        return this;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public Treino setFim(LocalDateTime fim) {
        this.fim = fim;
        return this;
    }

    public Fundamento getFundamento() {
        return fundamento;
    }

    public Treino setFundamento(Fundamento fundamento) {
        this.fundamento = fundamento;
        return this;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public Treino setAtleta(Atleta atleta) {
        this.atleta = atleta;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Treino{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", descricao='").append(descricao).append('\'');
        sb.append(", preparador=").append(preparador);
        sb.append(", inicio=").append(inicio);
        sb.append(", fim=").append(fim);
        sb.append(", fundamento=").append(fundamento);
        sb.append(", atleta=").append(atleta);
        sb.append('}');
        return sb.toString();
    }
}
