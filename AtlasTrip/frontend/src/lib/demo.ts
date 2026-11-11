import type { Destino, Viagem } from "./types";
export const destinos: Destino[] = [
  {slug:"japao",nome:"Japão",pais:"Ásia Oriental",resumo:"Cidades vibrantes e tradições milenares",tema:"japao"},
  {slug:"italia",nome:"Itália",pais:"Europa",resumo:"Arte, história e gastronomia",tema:"italia"},
  {slug:"suica",nome:"Suíça",pais:"Europa",resumo:"Montanhas, lagos e vilarejos",tema:"suica"},
  {slug:"china",nome:"China",pais:"Ásia Oriental",resumo:"Cultura e paisagens monumentais",tema:"china"},
  {slug:"croacia",nome:"Croácia",pais:"Europa",resumo:"Cidades históricas e litoral",tema:"croacia"},
  {slug:"turquia",nome:"Turquia",pais:"Europa e Ásia",resumo:"Mercados, mesquitas e paisagens",tema:"turquia"}
];
const bases = [
  {destino:"japao",titulo:"Essências do Japão",dias:11,preco:13980,resumo:"Tóquio, Kyoto e Osaka",lugares:["Chegada a Tóquio","Bairros de Tóquio","Templos e jardins","Viagem a Kyoto","Kyoto histórica","Passeio em Nara","Chegada a Osaka","Osaka gastronômica","Dia livre","Experiências culturais","Retorno"]},
  {destino:"italia",titulo:"Caminhos da Itália",dias:10,preco:10980,resumo:"Roma, Florença e Veneza",lugares:["Chegada a Roma","Roma antiga","Vaticano","Rumo à Toscana","Florença","Vilas toscanas","Viagem a Veneza","Canais de Veneza","Dia livre","Retorno"]},
  {destino:"suica",titulo:"Suíça Panorâmica",dias:8,preco:12980,resumo:"Zurique, Lucerna e Alpes",lugares:["Chegada a Zurique","Centro histórico","Lucerna","Passeio nos Alpes","Lagos alpinos","Vilarejos","Dia livre","Retorno"]},
  {destino:"china",titulo:"China Imperial",dias:10,preco:11980,resumo:"Pequim, Xi’an e Xangai",lugares:["Chegada a Pequim","Pequim histórica","Grande Muralha","Rumo a Xi’an","Patrimônio de Xi’an","Viagem a Xangai","Xangai clássica","Xangai moderna","Dia livre","Retorno"]},
  {destino:"croacia",titulo:"Encantos da Croácia",dias:9,preco:9980,resumo:"Dubrovnik, Split e ilhas",lugares:["Chegada a Dubrovnik","Cidade antiga","Costa dálmata","Passeio de barco","Chegada a Split","Palácio histórico","Ilhas próximas","Dia livre","Retorno"]},
  {destino:"turquia",titulo:"Turquia Cultural",dias:9,preco:9480,resumo:"Istambul e Capadócia",lugares:["Chegada a Istambul","Centro histórico","Mercados tradicionais","Bósforo","Rumo à Capadócia","Vales e paisagens","Cidades subterrâneas","Dia livre","Retorno"]}
];
export const viagens: Viagem[] = bases.flatMap((b,i)=> [0,1,2].map((n)=>({
 id:i*3+n+1,titulo:b.titulo,destino:b.destino,
 dataSaida:[`2027-${String(3+i).padStart(2,'0')}-12`,`2027-${String(4+i).padStart(2,'0')}-18`,`2027-${String(5+i).padStart(2,'0')}-08`][n],
 dias:b.dias,preco:b.preco+n*420,resumo:b.resumo,
 roteiro:b.lugares.map((titulo,dia)=>({dia:dia+1,titulo,descricao:`Programação demonstrativa: ${titulo.toLowerCase()}, com tempo para explorar a região e conhecer suas atrações.`}))
})));
