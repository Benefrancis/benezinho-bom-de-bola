package br.com.fiap;

import br.com.fiap.model.Atleta;
import br.com.fiap.model.Fundamento;
import br.com.fiap.model.Preparador;
import br.com.fiap.model.Treino;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager manager = factory.createEntityManager();

        //salvar(manager);

        findAll(manager);

        manager.close();
        factory.close();

    }

    private static void findAll(EntityManager manager) {

        String hql = """
                SELECT t FROM Treino t 
                         left join fetch t.atleta a 
                         left join fetch t.fundamento f 
                         left join fetch t.preparador p
                """;

        manager.createQuery(hql)
                .getResultList()
                .forEach(System.out::println);
    }

    private static void salvar(EntityManager manager) {
        //Dados do Fundamento
        Fundamento f = new Fundamento();
        f.setNome("Chute chapado " + String.valueOf(new Random().nextInt(100) + 1));

        //Dados do Atleta
        Atleta a = new Atleta();
        a.setAltura(1.8f)
                .setCPF(String.valueOf(new Random().nextInt(999999999) + 1))
                .setPeso(65.3f)
                .setNascimento(LocalDate.of(2006, 01, 06))
                .setNome("Erick Sudré do Nascimento");

        //Dados do Preparador
        Preparador p = new Preparador();
        p.setCREF(String.valueOf(new Random().nextInt(999999) + 1))
                .setNome("Altair Ramos");
        //Dados do Treino
        Treino t = new Treino();
        t.setNome("Chutes Alternados")
                .setDescricao("Chutes alternados de frente para o gol")
                .setFundamento(f)
                .setAtleta(a)
                .setPreparador(p)
                .setInicio(LocalDateTime.now())
                .setFim(LocalDateTime.now().plusMinutes(30));

        manager.getTransaction().begin();
        manager.persist(t);
        manager.getTransaction().commit();
    }
}