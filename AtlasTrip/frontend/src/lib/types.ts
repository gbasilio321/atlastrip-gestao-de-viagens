export type Dia = { dia: number; titulo: string; descricao: string };
export type Destino = { slug: string; nome: string; pais: string; resumo: string; tema: string };
export type Viagem = { id: number; titulo: string; destino: string; dataSaida: string; dias: number; preco: number; resumo: string; roteiro: Dia[] };
