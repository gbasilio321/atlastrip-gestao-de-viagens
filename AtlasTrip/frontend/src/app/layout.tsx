import type { Metadata } from "next";
import Link from "next/link";
import "./globals.css";
export const metadata:Metadata={title:"AtlasTrip | Gestão de Viagens",description:"Aplicativo demonstrativo de gestão e consulta de viagens"};
export default function Layout({children}:{children:React.ReactNode}){return <html lang="pt-BR"><body><header className="header"><div className="shell nav"><Link className="brand" href="/"><span className="brandmark">✦</span> Atlas<span>Trip</span></Link><nav><Link href="/">Início</Link><Link href="/viagens">Explorar viagens</Link></nav><span className="navbadge">PROJETO DEMO</span></div></header>{children}<footer><div className="shell footerinner"><div><strong>✦ AtlasTrip</strong><p>Uma experiência fictícia para portfólio de desenvolvimento.</p></div><span>Next.js · Java · Spring Boot · API REST</span></div></footer></body></html>}
