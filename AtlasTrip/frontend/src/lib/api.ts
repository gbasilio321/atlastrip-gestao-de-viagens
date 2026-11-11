import { destinos as locaisDestinos, viagens as locaisViagens } from "./demo";
import type { Destino, Viagem } from "./types";
const base = process.env.NEXT_PUBLIC_API_URL || "http://localhost:8080";
export async function carregarDados(): Promise<{destinos:Destino[];viagens:Viagem[];demo:boolean}> {
 try {
  const [d,v] = await Promise.all([
   fetch(`${base}/api/destinos`,{signal:AbortSignal.timeout(3500)}),
   fetch(`${base}/api/viagens`,{signal:AbortSignal.timeout(3500)})
  ]);
  if (!d.ok || !v.ok) throw new Error("API indisponível");
  const [destinos,viagens] = await Promise.all([d.json(),v.json()]);
  if (!Array.isArray(destinos)||!Array.isArray(viagens)) throw new Error("Resposta inválida");
  return {destinos,viagens,demo:false};
 } catch {return {destinos:locaisDestinos,viagens:locaisViagens,demo:true};}
}
