package dev.portfolio.atlastrip.api;
import dev.portfolio.atlastrip.model.Destino;
import dev.portfolio.atlastrip.repository.DestinoRepository;
import dev.portfolio.atlastrip.repository.ViagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins={"http://localhost:3000","http://127.0.0.1:3000"})
public class CatalogoController {
 private final DestinoRepository destinos;
 private final ViagemRepository viagens;
 public CatalogoController(DestinoRepository destinos,ViagemRepository viagens){this.destinos=destinos;this.viagens=viagens;}
 @GetMapping("/health") public Map<String,String> health(){return Map.of("status","ok","aplicacao","AtlasTrip Demo");}
 @GetMapping("/destinos") public List<Destino> destinos(){return destinos.findAll().stream().sorted(Comparator.comparing(Destino::getNome)).toList();}
 @GetMapping("/viagens") public ResponseEntity<?> viagens(@RequestParam(required=false) String destino,@RequestParam(required=false) String mes){
   YearMonth periodo=null;
   if(mes!=null&&!mes.isBlank()) {try {periodo=YearMonth.parse(mes);}catch(DateTimeParseException e){return ResponseEntity.badRequest().body(Map.of("erro","Use mes no formato AAAA-MM"));}}
   final YearMonth filtro=periodo;
   return ResponseEntity.ok(viagens.findAll().stream().filter(v->destino==null||destino.isBlank()||v.getDestino().getSlug().equalsIgnoreCase(destino)).filter(v->filtro==null||YearMonth.from(v.getDataSaida()).equals(filtro)).sorted(Comparator.comparing(v->v.getDataSaida())).map(ViagemResponse::from).toList());
 }
 @GetMapping("/viagens/{id}") public ResponseEntity<ViagemResponse> viagem(@PathVariable Long id){return viagens.findById(id).map(v->ResponseEntity.ok(ViagemResponse.from(v))).orElseGet(()->ResponseEntity.notFound().build());}
}
