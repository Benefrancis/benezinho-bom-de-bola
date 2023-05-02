package br.com.fiap.model;

import jakarta.persistence.*;

/**
 * @author Benefrancis do Nascimento
 * <p>
 * Classe que representa o profissional de Educação Física
 */
@Entity
@Table(name = "TB_PREPARADOR",
        uniqueConstraints = {@UniqueConstraint(
                name = "UK_NR_CREF",
                columnNames = "NR_CREF"
        )})
public class Preparador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PREPARADOR")
    @SequenceGenerator(name = "SQ_PREPARADOR", sequenceName = "SQ_PREPARADOR")
    @Column(name = "ID_PREPARADOR")
    private long id;

    @Column(name = "NM_PREPARADOR")
    private String nome;

    //Número de registro no Conselho Regional de Educação Física
    @Column(name = "NR_CREF")
    private String CREF;

    public Preparador() {
    }

    public Preparador(long id, String nome, String CREF) {
        this.id = id;
        this.nome = nome;
        this.CREF = CREF;
    }


    public long getId() {
        return id;
    }

    public Preparador setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Preparador setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCREF() {
        return CREF;
    }

    public Preparador setCREF(String CREF) {
        this.CREF = CREF;
        return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Preparador{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", CREF='").append(CREF).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
