package dev.portfolio.atlastrip.api;
import dev.portfolio.atlastrip.model.Viagem;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
public record ViagemResponse(Long id,String titulo,String destino,LocalDate dataSaida,int dias,BigDecimal preco,String resumo,List<DiaResponse> roteiro) {
    public record DiaResponse(int dia,String titulo,String descricao) {}
    public static ViagemResponse from(Viagem v){return new ViagemResponse(v.getId(),v.getTitulo(),v.getDestino().getSlug(),v.getDataSaida(),v.getDias(),v.getPreco(),v.getResumo(),v.getRoteiro().stream().map(d->new DiaResponse(d.getDia(),d.getTitulo(),d.getDescricao())).toList());}
}
