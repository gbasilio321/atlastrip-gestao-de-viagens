package dev.portfolio.atlastrip.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Viagem {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String titulo;
    @ManyToOne(optional=false) @JoinColumn(name="destino_slug") private Destino destino;
    @Column(nullable=false) private LocalDate dataSaida;
    private int dias;
    @Column(precision=12,scale=2) private BigDecimal preco;
    private String resumo;
    @OneToMany(mappedBy="viagem",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
    @OrderBy("dia ASC") private List<DiaRoteiro> roteiro=new ArrayList<>();
    protected Viagem() {}
    public Viagem(String titulo,Destino destino,LocalDate dataSaida,int dias,BigDecimal preco,String resumo){this.titulo=titulo;this.destino=destino;this.dataSaida=dataSaida;this.dias=dias;this.preco=preco;this.resumo=resumo;}
    public void adicionarDia(int dia,String titulo,String descricao){roteiro.add(new DiaRoteiro(this,dia,titulo,descricao));}
    public Long getId(){return id;}
    public String getTitulo(){return titulo;}
    public Destino getDestino(){return destino;}
    public LocalDate getDataSaida(){return dataSaida;}
    public int getDias(){return dias;}
    public BigDecimal getPreco(){return preco;}
    public String getResumo(){return resumo;}
    public List<DiaRoteiro> getRoteiro(){return roteiro;}
}
