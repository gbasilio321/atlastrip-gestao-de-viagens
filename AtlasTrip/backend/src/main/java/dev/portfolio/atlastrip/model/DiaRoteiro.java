package dev.portfolio.atlastrip.model;
import jakarta.persistence.*;
@Entity
public class DiaRoteiro {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional=false) @JoinColumn(name="viagem_id") private Viagem viagem;
    private int dia;
    private String titulo;
    @Column(length=1000) private String descricao;
    protected DiaRoteiro() {}
    public DiaRoteiro(Viagem viagem,int dia,String titulo,String descricao){this.viagem=viagem;this.dia=dia;this.titulo=titulo;this.descricao=descricao;}
    public int getDia(){return dia;}
    public String getTitulo(){return titulo;}
    public String getDescricao(){return descricao;}
}
