import { Suspense } from "react";
import Catalogo from "./catalogo";
export default function ViagensPage(){return <Suspense fallback={<main className="shell section">Carregando catálogo...</main>}><Catalogo/></Suspense>}
