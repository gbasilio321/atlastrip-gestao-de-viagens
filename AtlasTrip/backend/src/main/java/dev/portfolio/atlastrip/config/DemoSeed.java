package dev.portfolio.atlastrip.config;
import dev.portfolio.atlastrip.model.Destino;
import dev.portfolio.atlastrip.model.Viagem;
import dev.portfolio.atlastrip.repository.DestinoRepository;
import dev.portfolio.atlastrip.repository.ViagemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;
import java.time.LocalDate;
@Configuration
public class DemoSeed {
 @Bean CommandLineRunner seed(DestinoRepository destinos,ViagemRepository viagens){return args->{
  if(viagens.count()>0)return;
  String[][] ds={{"japao","Japão","Ásia Oriental","Cidades vibrantes e tradições milenares","⛩️","japao"},{"italia","Itália","Europa","Arte, história e gastronomia","🏛️","italia"},{"suica","Suíça","Europa","Montanhas, lagos e vilarejos","🏔️","suica"},{"china","China","Ásia Oriental","Cultura e paisagens monumentais","🏯","china"},{"croacia","Croácia","Europa","Cidades históricas e litoral","⛵","croacia"},{"turquia","Turquia","Europa e Ásia","Mercados, mesquitas e paisagens","🕌","turquia"}};
  for(String[] d:ds)destinos.save(new Destino(d[0],d[1],d[2],d[3],d[4],d[5]));
  String[][] bs={{"japao","Essências do Japão","11","13980","Tóquio, Kyoto e Osaka","Chegada a Tóquio|Bairros de Tóquio|Templos e jardins|Viagem a Kyoto|Kyoto histórica|Passeio em Nara|Chegada a Osaka|Osaka gastronômica|Dia livre|Experiências culturais|Retorno"},{"italia","Caminhos da Itália","10","10980","Roma, Florença e Veneza","Chegada a Roma|Roma antiga|Vaticano|Rumo à Toscana|Florença|Vilas toscanas|Viagem a Veneza|Canais de Veneza|Dia livre|Retorno"},{"suica","Suíça Panorâmica","8","12980","Zurique, Lucerna e Alpes","Chegada a Zurique|Centro histórico|Lucerna|Passeio nos Alpes|Lagos alpinos|Vilarejos|Dia livre|Retorno"},{"china","China Imperial","10","11980","Pequim, Xi’an e Xangai","Chegada a Pequim|Pequim histórica|Grande Muralha|Rumo a Xi’an|Patrimônio de Xi’an|Viagem a Xangai|Xangai clássica|Xangai moderna|Dia livre|Retorno"},{"croacia","Encantos da Croácia","9","9980","Dubrovnik, Split e ilhas","Chegada a Dubrovnik|Cidade antiga|Costa dálmata|Passeio de barco|Chegada a Split|Palácio histórico|Ilhas próximas|Dia livre|Retorno"},{"turquia","Turquia Cultural","9","9480","Istambul e Capadócia","Chegada a Istambul|Centro histórico|Mercados tradicionais|Bósforo|Rumo à Capadócia|Vales e paisagens|Cidades subterrâneas|Dia livre|Retorno"}};
  for(int i=0;i<bs.length;i++){
   String[] b=bs[i];String[] lugares=b[5].split("\\|");
   for(int n=0;n<3;n++){
    int mes=3+i+n;int dia=n==0?12:n==1?18:8;
    Viagem v=new Viagem(b[1],destinos.findById(b[0]).orElseThrow(),LocalDate.of(2027,mes,dia),Integer.parseInt(b[2]),new BigDecimal(b[3]).add(BigDecimal.valueOf(n*420L)),b[4]);
    for(int k=0;k<lugares.length;k++)v.adicionarDia(k+1,lugares[k],"Programação demonstrativa: "+lugares[k].toLowerCase()+", com tempo para explorar a região e conhecer suas atrações.");
    viagens.save(v);
   }
  }
 };}
}
