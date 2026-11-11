package dev.portfolio.atlastrip.model;
import jakarta.persistence.*;
@Entity
public class Destino {
    @Id private String slug;
    @Column(nullable=false) private String nome;
    private String pais;
    private String resumo;
    private String emoji;
    private String tema;
    protected Destino() {}
    public Destino(String slug,String nome,String pais,String resumo,String emoji,String tema){this.slug=slug;this.nome=nome;this.pais=pais;this.resumo=resumo;this.emoji=emoji;this.tema=tema;}
    public String getSlug(){return slug;}
    public String getNome(){return nome;}
    public String getPais(){return pais;}
    public String getResumo(){return resumo;}
    public String getEmoji(){return emoji;}
    public String getTema(){return tema;}
}
